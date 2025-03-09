package com.sjy.support.evict;

import com.sjy.api.ICacheEntry;
import com.sjy.api.ICacheEvict;
import com.sjy.api.ICacheEvictContext;

public abstract class AbstractCacheEvict<K, V> implements ICacheEvict<K, V> {
    @Override
    public ICacheEntry<K, V> evict(ICacheEvictContext<K, V> context) {
        return doEvict(context);
    }

    /**
     * 执行移除
     *
     * @param context 上下文
     * @return 结果
     * @since 0.0.11
     */
    protected abstract ICacheEntry<K, V> doEvict(ICacheEvictContext<K, V> context);

}
