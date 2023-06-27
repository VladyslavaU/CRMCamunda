package com.crm.camunda.crmcamunda;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableProcessApplication
public class CrmCamundaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmCamundaApplication.class, args);
    }

}
