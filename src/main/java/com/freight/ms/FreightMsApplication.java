package com.freight.ms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wyq on 2018/3/24.
 */

@SpringBootApplication
@MapperScan("com.freight.ms.dao")
public class FreightMsApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FreightMsApplication.class, args);
    }
}
