package com.shuwang.wbms.common.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Q-ays.
 * whosqays@gmail.com
 * 03-05-2018 16:26
 */

@Component
public class TestScheduler1 {

//    @Scheduled(cron="0/10 * *  * * ? ")
    public void task(){
        System.out.println("what the fuuuuuuuuuuuuuuuuuuuuuck!");
        System.out.println(System.nanoTime());
    }
}
