package common;

import org.apache.thrift.TException;

public class HelloServiceImpl implements HelloService.Iface {
    @Override
    public String helloString(String s) throws TException {
        return s;
    }
}
