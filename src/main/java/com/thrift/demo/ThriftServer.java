package com.thrift.demo;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.springframework.stereotype.Component;

@Component
public class ThriftServer {
    private TBinaryProtocol.Factory protocolFactory;
    private TTransportFactory transportFactory;

    public void init() {
        protocolFactory = new TBinaryProtocol.Factory();
        transportFactory = new TTransportFactory();
    }

    public void start() {
        Hello.Processor processor = new Hello.Processor<Hello.Iface>(new HelloServiceImpl());
        init();
        try {
            TServerTransport transport = new TServerSocket(7911);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
            tArgs.processor(processor);
            tArgs.protocolFactory(protocolFactory);
            tArgs.transportFactory(transportFactory);
            tArgs.minWorkerThreads(2);
            tArgs.maxWorkerThreads(1);
            TServer server = new TSimpleServer(tArgs);
            System.out.println("thrift服务启动成功, 端口=7911");
            server.serve();
        } catch (Exception e) {
            System.out.println("thrift服务启动失败");
        }

    }
}
