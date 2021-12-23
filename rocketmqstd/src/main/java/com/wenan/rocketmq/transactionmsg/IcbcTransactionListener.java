package com.wenan.rocketmq.transactionmsg;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * 描述 事务监听器
 */
public class IcbcTransactionListener implements TransactionListener {
    /**
     * 回调操作
     * 消息预提交成功就会触发该方法的执行，用于执行本地事务
     * 这里模拟一下
     * tagA就是扣款成功
     * tagB就是扣款失败
     * tagC就是不知道成没成功，要执行消息回查
     * @param message 传入的消息
     * @param arg 参数
     * @return 事务状态
     */
    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object arg) {
        System.out.println("预提交消息成功："+message);
        if(StringUtils.equals("TAGA",message.getTags())){
            return LocalTransactionState.COMMIT_MESSAGE;
        }else if(StringUtils.equals("TAGB",message.getTags())){
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }else if(StringUtils.equals("TAGC",message.getTags())){
            return LocalTransactionState.UNKNOW;
        }
        return LocalTransactionState.UNKNOW;
    }

    /**
     * 消息回查方法
     * 这里模拟出来表示回查就返回成功状态
     *
     * 常见的两个引发消息回查的原因：
     *  1. 回调操作返回UNKNWON
     *  2. TC没有接收到TM的最终全局事务确认指令
     * @param messageExt 回查消息
     * @return 事务状态
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        System.out.println("执行消息回查："+messageExt.getTags());
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
