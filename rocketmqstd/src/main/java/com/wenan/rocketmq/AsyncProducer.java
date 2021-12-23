package com.wenan.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * 描述：    AsyncProducer 发送异步消息
 */
public class AsyncProducer {
    public static void main(String[] args) throws Exception {
        //创建一个producer，参数为producerGroup名称
        DefaultMQProducer producer=new DefaultMQProducer("pg");
        //设置name server地址
        producer.setNamesrvAddr("localhost:9876");
        //启动生产者
        producer.start();

        //设置异步发送不重试
        producer.setRetryTimesWhenSendAsyncFailed(0);
        //设置发送超时时间5000ms（5s），默认3000ms
        producer.setSendMsgTimeout(5000);
        //设定新创建的topic的queue数量为2，默认4
        producer.setDefaultTopicQueueNums(2);

        //测试生产并发送100条消息
        for(int i=0;i<100;i++){
            byte[] body=("Hi,"+i).getBytes();
            //创建Message，指定topic、tag和具体内容byte[]类型的body
            Message msg=new Message("AsyncTopic","AsyncTopic",body);
            //发送消息并获得result
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println(sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        }
        //这一步的休眠很重要！因为是异步发送，还没发送完就关闭producer了
        TimeUnit.SECONDS.sleep(3);
        //关闭producer
        producer.shutdown();
    }
}
