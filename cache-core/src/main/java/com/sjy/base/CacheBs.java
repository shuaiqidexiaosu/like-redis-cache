package com.sjy.base;

import com.github.houbb.heaven.util.common.ArgUtil;
import com.sjy.api.*;
import com.sjy.core.Cache;
import com.sjy.support.evict.CacheEvicts;
import com.sjy.support.listener.remove.CacheRemoveListeners;
import com.sjy.support.load.CacheLoads;
import com.sjy.support.persist.CachePersists;
import com.sjy.support.proxy.CacheProxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 缓存引导类
 * @since: 0.0.1
 * @author: 智慧的苏苏
 * @date: 2025/3/9 下午3:17
*/
public final class CacheBs<K, V> {
    private List<ICacheSlowListener> slowListeners;

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

    private final List<ICacheRemoveListener<K, V>> removeListeners = CacheRemoveListeners.defaults();

    private ICacheLoad<K, V> load = CacheLoads.none();

    private ICachePersist<K, V> persist = CachePersists.none();

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
