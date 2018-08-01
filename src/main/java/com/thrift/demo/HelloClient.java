package com.thrift.demo;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

public class HelloClient {
    private Hello.Client helloService;
    private TBinaryProtocol protocol;
    private TSocket transport;
    private String host;
    private int port;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void init() {
        transport = new TSocket("localhost", 7911);
        protocol = new TBinaryProtocol(transport);
        helloService = new Hello.Client(protocol);
    }

    public Hello.Client getHelloService() {
        return helloService;
    }

    public void open() throws TTransportException {
        transport.open();
    }

    public void close() {
        transport.close();
    }
}
