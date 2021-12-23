package com.wenan.rocketmq.delaymsg;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述：    DelayProducer 延时消息生产者
 */
public class DelayProducer {
    public static void main(String[] args) throws Exception {
        // 创建生产者
        DefaultMQProducer producer = new DefaultMQProducer("delayPg");
        // 生产者注册到Nameserver
        producer.setNamesrvAddr("localhost:9876");
        // 启动生产者
        producer.start();
        // 生产消息
        for (int i = 0; i < 20; i++) {
            // 创建消息主体
            byte[] body = ("delay" + i).getBytes();
            // 新建消息（包含topic，tag，message）
            Message message = new Message("delayTopic", "tagA", body);
            // 指定消息延迟等级3,10s
            message.setDelayTimeLevel(3);
            // 生产者发送消息，并且返回结果
            SendResult sendResult = producer.send(message);
            //输出消息发送的时间
            System.out.println(new SimpleDateFormat("mm:ss").format(new Date()));
            //输出消息返回结果
            System.out.println(" , "+sendResult);
        }
        // 关闭生产者
        producer.shutdown();
    }
}
