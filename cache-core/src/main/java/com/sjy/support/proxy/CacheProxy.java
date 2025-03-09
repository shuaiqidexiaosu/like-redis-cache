package com.sjy.support.proxy;


import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.sjy.api.ICache;

import java.lang.reflect.Proxy;

public final class CacheProxy {

    private CacheProxy() {
    }


    public static <K, V> ICache<K, V> getProxy(ICache<K, V> cache) {
        if (ObjectUtil.isNull(cache)) {
            return (ICache<K, V>) new NoneProxy(cache).proxy();
        }
        final Class clazz = cache.getClass();

        if (clazz.isInterface() || Proxy.isProxyClass(clazz)) {
            return (ICache<K, V>) new DynamicProxy(cache).proxy();
        }
        return (ICache<K, V>) new CglibProxy(cache).proxy();
    }

}
