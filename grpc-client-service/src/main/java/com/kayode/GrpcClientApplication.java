package com.kayode;

import com.kayode.service.BookAuthorClientService;
import net.devh.boot.grpc.client.autoconfigure.GrpcClientAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GrpcClientAutoConfiguration.class)
public class GrpcClientApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("GrpcClientApplication running.");
//        BookAuthorClientService bookAuthorClientService = new BookAuthorClientService();
        applicationContext.getBean(BookAuthorClientService.class);
    }
}