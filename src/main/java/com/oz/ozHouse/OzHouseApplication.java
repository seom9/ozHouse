package com.oz.ozHouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;


//@MapperScan(basePackageClasses = OzHouseApplication.class)
//@EnableBatchProcessing //spring batch 사용 설정
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@MapperScan(value = {"com.oz.ozHouse.mapper"})
@EnableJpaAuditing
@EnableScheduling
public class OzHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(OzHouseApplication.class, args);
        System.out.println("ozHouse 실행 완료!");
    }

}