package com.nzj.myclientzookeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@SpringBootApplication
public class MyClientZookeeperAApplication {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String home() {
        String s = restTemplate.getForObject("http://my-client-zookeeper/", String.class);
        return "获取到远程服务的结果: " + s;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyClientZookeeperAApplication.class, args);
    }

}
