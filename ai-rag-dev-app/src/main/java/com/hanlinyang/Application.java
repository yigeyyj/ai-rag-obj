package com.hanlinyang;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@Slf4j
@SpringBootApplication
@Configurable
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
