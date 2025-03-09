package com.sjy.support.evict;

import com.sjy.api.ICacheEntry;
import com.sjy.api.ICacheEvictContext;

public class CacheEvictFifo<K, V> extends AbstractCacheEvict<K, V> {
    @Override
    protected ICacheEntry<K, V> doEvict(ICacheEvictContext<K, V> context) {
        return null;
    }

    @Override
    public void updateKey(K key) {

    }

    @Override
    public void removeKey(K key) {

    }
}
