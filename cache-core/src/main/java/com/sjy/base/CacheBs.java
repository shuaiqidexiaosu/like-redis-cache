package com.sjy.base;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.sjy.api.ICache;
import com.sjy.api.ICacheEvict;
import com.sjy.core.Cache;

import java.util.HashMap;
import java.util.Map;

public final class CacheBs<K, V> {
    private CacheBs() {
    }

    public static <K, V> CacheBs<K, V> newInstance() {
        return new CacheBs<>();
    }

    public CacheBs<K, V> size(int size) {
        ArgUtil.notNegative(size, "size");

        this.size = size;
        return this;
    }


    private Map<K, V> map = new HashMap<>();

    private int size = Integer.MAX_VALUE;

    private ICacheEvict<K, V> evict = CacheEvicts.fifo();


    public ICache<K, V> build() {
        Cache<K, V> cache = new Cache<>();
        cache.evict(evict);
        cache.map(map);
        cache.sizeLimit(size);
        cache.removeListeners(removeListeners);
        cache.load(load);
        cache.persist(persist);
        cache.slowListeners(slowListeners);

        // 初始化
        cache.init();
        return CacheProxy.getProxy(cache);
    }

}
