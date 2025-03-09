package com.sjy.support.persist;

import com.sjy.api.ICache;
import com.sjy.api.ICachePersist;

import java.util.concurrent.TimeUnit;

public class CachePersistAdapter<K, V> implements ICachePersist<K, V> {
    @Override
    public void persist(ICache<K, V> cache) {
        // TODO: persist cache data to redis or other storage
    }

    @Override
    public long delay() {
        return this.period();
    }

    @Override
    public long period() {
        return 1;
    }

    @Override
    public TimeUnit timeUnit() {
        return TimeUnit.SECONDS;
    }
}
