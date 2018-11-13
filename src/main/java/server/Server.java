package server;

import common.*;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class Server {
    public static void main(String args[]) {
        try{
            TProcessor tProcessor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
            TServerTransport serverTransport = new TServerSocket(50006);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(tProcessor));
            System.out.println("Service startup success.....");
            server.serve();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
