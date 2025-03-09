package com.sjy.support.load;

import com.sjy.api.ICacheLoad;

/**
 * 加载策略工具类
 *
 * @since: 0.0.1
 * @author: 智慧的苏苏
 * @date: 2025/3/7 下午11:38
 */
public class CacheLoads {
    private CacheLoads() {
    }


    public static <K, V> ICacheLoad<K, V> none() {
        return new CacheLoadNone<>();
    }

    public static <K, V> ICacheLoad<K, V> dbJson(final String dbJson) {
        return new CacheLoadDbJson<>(dbJson);
    }

    public static <K, V> ICacheLoad<K, V> aof(final String dbPath) {
        return new CacheLoadAof<>(dbPath);
    }

}
