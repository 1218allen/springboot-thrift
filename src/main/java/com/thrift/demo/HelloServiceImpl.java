package com.thrift.demo;

import org.apache.thrift.TException;

public class HelloServiceImpl implements Hello.Iface {

    @Override
    public String helloString(String para) throws TException {
        System.out.println(para);
        return "result:" + para;
    }
}
