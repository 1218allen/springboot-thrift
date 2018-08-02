//package com.thrift.demo;
//
//import org.apache.thrift.protocol.TBinaryProtocol;
//import org.apache.thrift.protocol.TProtocol;
//import org.apache.thrift.transport.TFramedTransport;
//import org.apache.thrift.transport.TSocket;
//import org.apache.thrift.transport.TTransport;
//import org.apache.thrift.transport.TTransportException;
//
//public class HelloClient {
//    private Hello.Client helloService;
//    private TProtocol protocol;
//    private TTransport transport;
//    private String host;
//    private int port;
//
//    public void setHost(String host) {
//        this.host = host;
//    }
//
//    public void setPort(int port) {
//        this.port = port;
//    }
//
//    public void init() throws Exception {
//        transport = new TFramedTransport(new TSocket(host, port));
//        protocol = new TBinaryProtocol(transport);
//        helloService = new Hello.Client(protocol);
//    }
//
//    public Hello.Client getHelloService() {
//        return helloService;
//    }
//
//    public void open() throws TTransportException {
//        transport.open();
//    }
//
//    public void close() {
//        transport.close();
//    }
//}
