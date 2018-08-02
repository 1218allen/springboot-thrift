package com.thrift.demo;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;


public class MethodCallback implements AsyncMethodCallback<String> {
    @Override
    public void onComplete(String response) {
        System.out.println(response);
    }

    @Override
    public void onError(Exception exception) {
        System.out.println("onError :" + exception.getMessage());
    }
}
