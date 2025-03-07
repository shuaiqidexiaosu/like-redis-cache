package com.sjy.api;

public interface ICacheEvictContext<K, V> {

    K key();

    /**
     * cache 实现
     *
     * @return map
     * @since 0.0.2
     */
    ICache<K, V> cache();

    /**
     * 获取大小
     *
     * @return 大小
     * @since 0.0.2
     */
    int size();
}
