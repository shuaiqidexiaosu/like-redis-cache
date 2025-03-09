package com.sjy.api;

import java.util.concurrent.TimeUnit;

/**
 * 缓存持久化接口
 *
 * @since: 0.0.1
 * @author: 智慧的苏苏
 * @date: 2025/3/9 上午10:13
 */
public interface CachePersist<K, V> {


    /**
     * 持久化缓存信息
     * @since: 0.0.1
     * @author: 智慧的苏苏
     * @date: 2025/3/9 上午10:16
     * @Param cache:
     * @return: void
     */
    void persist(final ICache<K, V> cache);

    long delay();

    long period();

    TimeUnit timeUnit();
}
