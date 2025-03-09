package com.sjy.support.proxy;

import com.sjy.annotation.CacheInterceptor;
import com.sjy.api.ICache;

import java.lang.reflect.Method;

public class CacheProxyBsContext implements ICacheProxyBsContext {


    /**
     * 目标
     *
     * @since 0.0.4
     */
    private ICache target;

    /**
     * 入参
     *
     * @since 0.0.4
     */
    private Object[] params;

    /**
     * 方法
     *
     * @since 0.0.4
     */
    private Method method;

    /**
     * 拦截器
     *
     * @since 0.0.5
     */
    private CacheInterceptor interceptor;


    public static CacheProxyBsContext newInstance() {
        return new CacheProxyBsContext();
    }

    @Override
    public CacheInterceptor interceptor() {
        return interceptor;
    }

    @Override
    public ICache cache() {
        return target;
    }

    @Override
    public ICacheProxyBsContext target(ICache target) {
        this.target = target;
        return this;
    }

    @Override
    public Object[] params() {
        return params;
    }


    public CacheProxyBsContext params(Object[] params) {
        this.params = params;
        return this;
    }

    @Override
    public Method method() {
        return method;
    }

    @Override
    public Object process() throws Throwable {
        return this.method.invoke(this.target, this.params);
    }

    public CacheProxyBsContext method(Method method) {
        this.method = method;
        this.interceptor = method.getAnnotation(CacheInterceptor.class);
        return this;
    }
}
