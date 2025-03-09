package com.sjy.support.evict;

import com.sjy.api.ICacheEvict;

public final class CacheEvicts {

    private CacheEvicts() {
    }

    public static <K, V> ICacheEvict<K, V> fifo() {
        return new CacheEvictFifo<>();
    }
}
