package cn.fyupeng;

import cn.fyupeng.util.ReflectUtil;

import java.io.IOException;
import java.util.Set;

/**
 * @Auther: fyp
 * @Date: 2022/10/20
 * @Description:
 * @Package: cn.fyupeng
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Set<Class<?>> classes = ReflectUtil.getClasses("cn.fyupeng");
        for (Class<?> aClass : classes) {
            System.out.println(aClass);
        }
    }
}
