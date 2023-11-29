package com.example.demo.listener;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;
import java.util.Map;

/**
 * 创建一个接口，作为自定义监听器的基础，这个接口需要定义监听器需要实现的方法
 *
 * @author alexzhang
 */
@Getter
@Setter
public class UserDefinedEvent extends ApplicationEvent {

    private Map<String, String> map;

    public UserDefinedEvent(Object source, Map<String, String> map) {
        super(source);
        this.map = map;
    }

    public UserDefinedEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
