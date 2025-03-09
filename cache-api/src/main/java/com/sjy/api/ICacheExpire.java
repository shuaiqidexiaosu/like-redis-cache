package com.sjy.api;

import java.util.Collection;

public interface ICacheExpire<K, V> {

    void expire(K key, final long expire);

    void refreshExpire(K key, V value, final Collection<K> keyList);

    Long expireTime(K key);
}
