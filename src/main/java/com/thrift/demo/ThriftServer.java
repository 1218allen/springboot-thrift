package com.thrift.demo;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.*;
import org.springframework.stereotype.Component;

@Component
public class ThriftServer {
    private TProtocolFactory protocolFactory;
    private TFramedTransport.Factory transportFactory;

    public void init() {
        protocolFactory = new TBinaryProtocol.Factory();
        transportFactory = new TFramedTransport.Factory();
    }

    public void start() {
        Hello.Processor processor = new Hello.Processor<Hello.Iface>(new HelloServiceImpl());
        init();

        try {
            TNonblockingServerSocket transport = new TNonblockingServerSocket(7911);
            TNonblockingServer.Args tArgs = new TNonblockingServer.Args(transport);
            tArgs.processor(processor);
            tArgs.protocolFactory(protocolFactory);
            tArgs.transportFactory(transportFactory);
            TServer server = new TNonblockingServer(tArgs);
            server.serve();

            System.out.println("thrift服务启动成功, 端口=7911");
        } catch (Exception e) {
            System.out.println("thrift服务启动失败");
        }
    }
}
