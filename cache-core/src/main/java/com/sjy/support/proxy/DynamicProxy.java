package com.sjy.support.proxy;

import com.sjy.api.ICache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler, ICacheProxy {

    /**
     * 被代理的对象
     */
    private final ICache target;

    public DynamicProxy(ICache target) {
        this.target = target;
    }

    @Override
    public Object proxy() {
        InvocationHandler handler = new DynamicProxy(target);
        return Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ICacheProxyBsContext context = CacheProxyBsContext.newInstance().
                method(method).params(args).target(target);

        return
    }
}
