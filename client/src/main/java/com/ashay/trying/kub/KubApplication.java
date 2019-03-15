package com.ashay.trying.kub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
@RestController
public class KubApplication {

    public static void main(String[] args) {
        SpringApplication.run(KubApplication.class, args);
    }


    @GetMapping
    public String hello() throws IOException {
        InputStream repsonseStream = new URL("http://server-service:8080").openStream();
        String responseFromServer = StreamUtils.copyToString(repsonseStream, StandardCharsets.UTF_8);
        return "I am client : " + InetAddress.getLocalHost().getHostName() + "\n From server : " + responseFromServer;
    }

}
