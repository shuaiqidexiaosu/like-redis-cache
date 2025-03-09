package com.sjy.support.load;

import com.sjy.api.ICache;
import com.sjy.api.ICacheLoad;

/**
 * 缓存加载策略-不加载
 *
 * @since: 0.0.1
 * @author: 智慧的苏苏
 * @date: 2025/3/9 上午9:53
 */
public class CacheLoadNone<K, V> implements ICacheLoad<K, V> {
    @Override
    public void load(ICache<K, V> cache) {
        // do nothing
    }
}
