package com.ashay.trying.kub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetAddress;

@SpringBootApplication
@RestController
public class KubApplication {

    public static void main(String[] args) {
        SpringApplication.run(KubApplication.class, args);
    }


    @GetMapping("/info")
    public String hello() throws IOException {
        return InetAddress.getLocalHost().getHostName();
    }

}
