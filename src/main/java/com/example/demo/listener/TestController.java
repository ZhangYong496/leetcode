package com.example.demo.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author alexzhang
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private UserDefinedTrigger userDefinedTrigger;

    @GetMapping("triggerEvent")
    public ResponseEntity<?> event() {
        log.info("==========start=============");
        Map<String, String> trigger = userDefinedTrigger.trigger();
        log.info("==========end=============");
        return new ResponseEntity<>(trigger, HttpStatus.OK);
    }

}
