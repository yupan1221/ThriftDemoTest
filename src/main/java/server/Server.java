package server;

import common.*;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class Server {
    public static void main(String args[]) {
        try {
            TProcessor tprocessor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
            TServerSocket serverTransport = new TServerSocket(50005);
            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
            TServer server = new TSimpleServer(tArgs);
            server.serve();
            System.out.println("服务端开启....");
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
