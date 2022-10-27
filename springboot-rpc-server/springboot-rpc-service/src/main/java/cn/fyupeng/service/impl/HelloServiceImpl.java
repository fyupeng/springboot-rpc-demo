package cn.fyupeng.service.impl;


import cn.fyupeng.anotion.Service;
import cn.fyupeng.service.HelloService;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: fyp
 * @Date: 2022/10/19
 * @Description: HelloWorld实现类
 * @Package: cn.fyupeng.cn.fyupeng.controller.impl
 * @Version: 1.0
 */

@Service
public class HelloServiceImpl implements HelloService {
   private AtomicInteger count = new AtomicInteger(0);
   @Override
   public String sayHello(String name) {
      try {
         System.out.println("调用次数" + count.incrementAndGet());
         Thread.sleep(new Random().nextInt(200));
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
      return "hello, my name is " + name;
   }
}
