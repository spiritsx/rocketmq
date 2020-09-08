/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2020. All Rights Reserved.
 */
package org.apache.rocketmq.example.quickstart;

import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.client.ClientConfig;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.protocol.body.TopicConfigSerializeWrapper;
import org.apache.rocketmq.common.protocol.body.TopicList;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.rocketmq.tools.admin.DefaultMQAdminExt;

/**
 * $ViewMessageDemo
 *
 * @author shixi
 * @version $Id: ViewMessageDemo.java,v 0.1 2020年09月01日 12:21 $Exp
 */
public class ViewMessageDemo {

    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setNamesrvAddr("localhost:9876");
        DefaultMQAdminExt defaultMQAdminExt = new DefaultMQAdminExt();
        defaultMQAdminExt.setNamesrvAddr("localhost:9876");
        defaultMQAdminExt.start();
//        MessageExt messageExt = defaultMQAdminExt.viewMessage("AC155AAC00002A9F0000000000000DC8");
//        System.out.println(messageExt);
        TopicList topicList = defaultMQAdminExt.fetchAllTopicList();
        TopicConfigSerializeWrapper allTopicGroup = defaultMQAdminExt.getAllTopicGroup("localhost:10911", 3000);
        System.out.println(JSON.toJSONString(allTopicGroup));
    }
}
