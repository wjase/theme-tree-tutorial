package com.cybernostics.themetree.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ThemetreeDemoApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ThemetreeDemoApplication.class, args);
    }

    @Controller
    public static class IndexController
    {

        @RequestMapping(
        {
            "/", "/index.html"
        })
        public String index()
        {
            return "index";
        }
    }

}
