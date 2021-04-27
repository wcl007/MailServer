package com.example.jamestest;

import com.example.jamestest.netty.smtp.SmtpServer;
import org.apache.james.protocols.api.handler.WiringException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JamesTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JamesTestApplication.class, args);
        try {
            new SmtpServer().start();
        } catch (WiringException e) {
            e.printStackTrace();
        }
    }
}
