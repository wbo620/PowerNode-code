package client;

import com.powernode.proxy.OrderService;
import com.powernode.proxy.OrderServiceImpl;
import com.powernode.proxy.OrderServiceProxy;

public class Test {
    public static void main(String[] args) {
        OrderService orderService=new OrderServiceImpl();
        OrderServiceProxy proxy = new OrderServiceProxy(orderService);
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }
}
