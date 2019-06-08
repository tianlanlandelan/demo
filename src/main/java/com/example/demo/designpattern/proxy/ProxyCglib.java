package com.example.demo.designpattern.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 使用CGLIB实现的代理模式
 * Spring AOP 就是通过 CGLIB 来动态地生成代理对象，运行时生成代理对象，而不是在编译时
 * Hibernate 也是通过 CGLIB 来实现动态代理的
 * @author yangkaile
 * @date 2019-06-07 18:12:32
 */
public class ProxyCglib implements MethodInterceptor {
    /**
     * 业务对象类，供代理方法中进行真正的业务方法调用
     */
    private Object target;

    /**
     * 动态绑定
     * @param target
     * @return
     */
    public Object getInstance(Object target){
        this.target = target;
        //创建加强器，用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        //为加强器指定要代理的业务类（即：为生成的代理类指定父类）
        enhancer.setSuperclass(this.target.getClass());
        //设置回调
        enhancer.setCallback(this);
        //创建代理类对象并返回
        return  enhancer.create();
    }

    /**
     * 实现处理代理逻辑的业务类
     * @param object
     * @param method
     * @param args
     * @param proxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable{
        System.out.println("预处理，" + method.getDeclaringClass().getSimpleName() + "," + method.getName());
        Object result = proxy.invokeSuper(object,args);
        System.out.println("调用后操作");
        return result;
    }

}
