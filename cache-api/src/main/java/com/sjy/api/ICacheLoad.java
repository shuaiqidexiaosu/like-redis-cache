package com.sjy.api;

public interface ICacheLoad<K, V> {


    /**
     * 加载缓存信息
     *
     * @param cache 缓存
     * @since 0.0.7
     */
    void load(final ICache<K, V> cache);
}
