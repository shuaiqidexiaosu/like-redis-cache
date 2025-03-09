package com.sjy.support.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NoneProxy implements InvocationHandler, ICacheProxy {

    private final Object target;


    public NoneProxy(Object target) {
        this.target = target;
    }


    @Override
    public Object proxy() {
        return this.target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
