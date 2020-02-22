package com.lily.untis;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author: liling
 * @date: Created in 2020/2/22
 * @description:
 * @version:1.0
 */
@Component //component让spring容器可以扫描到
public class Timer {

    /**
     *使用schedule注解, 容器一启动就会按照要求的执行频率执行
     * corn表达式可以协助进行更好的定时器任务, 可百度
     */
    @Scheduled(fixedRate = 1000)
    public void task(){
        System.out.println(LocalDateTime.now());
    }

}
