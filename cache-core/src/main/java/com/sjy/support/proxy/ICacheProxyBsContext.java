package com.sjy.support.proxy;

import com.sjy.annotation.CacheInterceptor;
import com.sjy.api.ICache;

import java.lang.reflect.Method;

public interface ICacheProxyBsContext {

    CacheInterceptor interceptor();

    ICache cache();


    ICacheProxyBsContext target(final ICache target);

    Object[] params();

    Method method();

    Object process() throws Throwable;


}
