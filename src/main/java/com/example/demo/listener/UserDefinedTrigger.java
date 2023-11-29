package com.example.demo.listener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

/**
 * 定义一个发布事件的触发器
 *
 * @author alexzhang
 */
@Component
public class UserDefinedTrigger {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    public Map<String ,String> trigger(){

        Map<String,String> map = new HashMap<>(16);
        map.put("自定义","Mr.Zhang");
        map.put("小憨包","keXin");
        UserDefinedEvent event = new UserDefinedEvent(this, map);
        applicationEventPublisher.publishEvent(event);
        System.out.println(map);
        return map;
    }

}
