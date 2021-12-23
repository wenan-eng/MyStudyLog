package com.wenan.rocketmq.transactionmsg;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * 描述：    SomeConsumer 消费者
 */
public class TransactionConsumer {

    public static void main(String[] args) throws MQClientException {
        //定义一个Pull消费者
//        DefaultMQPullConsumer pullConsumer=new DefaultMQPullConsumer("cg");
        //定义一个Push消费者
        DefaultMQPushConsumer consumer=new DefaultMQPushConsumer("cg");
        consumer.setNamesrvAddr("localhost:9876");
        //指定从第一条消息开始消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //订阅消费的topic与tag（此处tag为通配符表示所有）
        consumer.subscribe("TransactionTopic","*");

        //指定消费模式：广播模式，默认为集群模式
        consumer.setMessageModel(MessageModel.BROADCASTING);


        //注册消息监听器
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            //消费消息代码，一旦broker中有了其订阅的消息就会触发该代码的执行
            //返回值为当前消费的状态
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt messageExt : list) {
                    System.out.println(messageExt);
                }
                //CONSUME_SUCCESS消费成功
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //开启消费
        consumer.start();
        System.out.println("consumer start");
    }
}
