package com.wenan.rocketmq.delaymsg;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 描述：    DelayConsumer 延迟消息消费者
 */
public class DelayConsumer {
    public static void main(String[] args) throws Exception {
        // 新建消费者组
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("delayPg");
        // 消费者组注册到Nameserver
        consumer.setNamesrvAddr("localhost:9876");
        // 设置消费顺序
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        // 设置消费主题，消费标签
        consumer.subscribe("delayTopic","*");
        // 监听消息队列
        consumer.registerMessageListener(new MessageListenerConcurrently(){

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext context) {
                for (MessageExt messageExt : list) {
                    //输出消费时的时间
                    System.out.println(new SimpleDateFormat("mm:ss").format(new Date()));
                    System.out.println(messageExt);
                }
                //CONSUME_SUCCESS消费成功
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 开启消费者
        consumer.start();
        System.out.println("开始消费");
    }
}
