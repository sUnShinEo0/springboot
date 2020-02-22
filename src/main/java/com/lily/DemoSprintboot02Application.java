package com.lily;

import com.lily.untis.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DemoSprintboot02Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoSprintboot02Application.class, args);
    }

}
