package com.nowcoder.community.event;

import com.alibaba.fastjson.JSONObject;
import com.nowcoder.community.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    // 处理事件
    public void fireEvent(Event event) {
        // 将事件发布到指定的主题  这边将数据转化为json格式字符串发送过去，这样能让消费者自己根据业务处理json数据
        kafkaTemplate.send(event.getTopic(), JSONObject.toJSONString(event));
    }

}
