package com.thrift.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloClientController {
    @Autowired
    HelloClient helloClient;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hi(@RequestParam("name") String name) {
        String s = "nobody";

        try {
            helloClient.open();
            s = helloClient.getHelloService().helloString(name);
        } catch (Exception e) {

        } finally {
            helloClient.close();
        }

        return s;
    }
}
