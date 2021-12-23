package com.wenan.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * 描述：    OneWayProducer 单向发送消息
 */
public class OneWayProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException {
        DefaultMQProducer producer=new DefaultMQProducer("pg");
        producer.setNamesrvAddr("localhost:9876");
        producer.start();

        for(int i=0;i<100;i++){
            byte[] body=("Hi2222oo,"+i).getBytes();
            Message msg=new Message("OneWayTopic","OneWayTopic",body);
            //单向发送
            producer.sendOneway(msg);
        }
        producer.shutdown();
        System.out.println("producer shutdown");
    }
}
