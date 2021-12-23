package com.wenan.rocketmq.transactionmsg;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 描述：    TransactionProducer 事务消息生产者
 */
public class TransactionProducer {
    public static void main(String[] args) throws MQClientException {
        TransactionMQProducer producer = new TransactionMQProducer("tpg");
        producer.setNamesrvAddr("localhost:9876");

        /**
         * 定义一个线程池
         * @param corePoolSize，核心线程数
         * @param maximumPoolSize，最多线程数
         * @param keepAliveTime，保持活跃的时间：当线程池中线程数量大于核心线程数量时，多余空闲线程的存活时长
         * @param unit，时间单位
         * @param workQueue，临时存放任务的工作队列
         * @param threadFactory，线程工厂
         */
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                2,
                5,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(200),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("client-transaction-msg-check-thread");
                        return thread;
                    }
                });

        //为生产者指定刚刚定义的线程池
        producer.setExecutorService(executorService);
        //为生产者指定任务监听器
        producer.setTransactionListener(new IcbcTransactionListener());

        producer.start();
        String[] tags={"TAGA","TAGB","TAGC"};
        for(int i=0;i<3;i++){
            byte[] body=("Hi"+i).getBytes();
            Message msg=new Message("TransactionTopic",tags[i],body);
            //发送事务消息
            //第二个参数用于指定在执行本地事务时需要使用的业务参数
            TransactionSendResult result = producer.sendMessageInTransaction(msg, null);
            System.out.println("发送结果为："+result.getSendStatus());
        }
    }
}
