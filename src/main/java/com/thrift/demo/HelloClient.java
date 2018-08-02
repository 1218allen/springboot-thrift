package com.thrift.demo;

import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;


public class HelloClient {
    private Hello.AsyncClient helloService;
    private TProtocolFactory protocol;
    private TNonblockingSocket transport;
    private String host;
    private int port;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void init() throws Exception {
        TAsyncClientManager clientManager = new TAsyncClientManager();
        transport = new TNonblockingSocket(host, port);
        protocol = new TBinaryProtocol.Factory();
        helloService = new Hello.AsyncClient(protocol, clientManager, transport);
    }

    public Hello.AsyncClient getHelloService() {
        return helloService;
    }
}
