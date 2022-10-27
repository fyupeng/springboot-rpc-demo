package cn.fyupeng.controller;

import cn.fyupeng.anotion.Reference;
import cn.fyupeng.loadbalancer.RandomLoadBalancer;
import cn.fyupeng.net.netty.client.NettyClient;
import cn.fyupeng.proxy.RpcClientProxy;
import cn.fyupeng.serializer.CommonSerializer;
import cn.fyupeng.service.HelloService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utils.JSONResult;

import javax.annotation.PostConstruct;


/**
 * @Auther: fyp
 * @Date: 2022/10/19
 * @Description: HelloWorld控制器
 * @Package: cn.fyupeng.cn.fyupeng.controller
 * @Version: 1.0
 */

@RequestMapping("/user")
@RestController
public class HelloController {

    //@Autowired
    //private HelloService helloService;

    private static final RandomLoadBalancer randomLoadBalancer = new RandomLoadBalancer();
    private static final NettyClient nettyClient = new NettyClient(randomLoadBalancer, CommonSerializer.KRYO_SERIALIZER);
    private static final RpcClientProxy rpcClientProxy = new RpcClientProxy(nettyClient);

    @Reference(timeout = 3000, asyncTime = 4000)
    //@Autowired
    private HelloService helloService;

    @PostConstruct
    public void init() {
        helloService = rpcClientProxy.getProxy(HelloService.class, HelloController.class);
    }

    @GetMapping("/hello")
    public JSONResult sayHello(String name) {
        return JSONResult.ok(helloService.sayHello(name));
    }

}
