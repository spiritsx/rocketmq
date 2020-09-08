/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2020. All Rights Reserved.
 */
package org.apache.rocketmq.example.quickstart;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;
import java.util.Set;

/**
 * @author shixi
 * @version $Id: PullConsumer.java,v 0.1 2020年04月24日 14:45 $Exp
 */
public class PullConsumer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("pullConsumer");
        consumer.setNamesrvAddr("localhost:9876");
        consumer.start();
        Set<MessageQueue> topicTest = consumer.fetchSubscribeMessageQueues("test_group-test_app-topic");
        for (MessageQueue messageQueue : topicTest) {
            long offset = consumer.fetchConsumeOffset(messageQueue, true);
            PullResult pull = consumer.pull(messageQueue, "*", offset, 1);
            List<MessageExt> msgFoundList = pull.getMsgFoundList();
            for (MessageExt messageExt : msgFoundList) {
                System.out.println(messageExt);
            }
        }
    }
}
