package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @EventListener 注解实现自定义监听器，对自定义的事件进行监听。
 * @author alexzhang
 */

@Component
@Slf4j
public class UserDefinedEventHandler {

    @EventListener
    public void handleUserDefinedEvent(UserDefinedEvent userDefinedEvent ){
        log.info("==========handleUserDefinedEvent===========");
        userDefinedEvent.getMap().put("小憨包","Ms.Chu");
    }

}
