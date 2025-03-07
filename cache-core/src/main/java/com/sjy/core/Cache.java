package com.sjy.core;

import com.sjy.api.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cache<K, V> implements ICache<K, V> {


    /**
     * map 信息
     *
     * @since 0.0.2
     */
    private Map<K, V> map;

    /**
     * 大小限制
     *
     * @since 0.0.2
     */
    private int sizeLimit;

    public Cache<K, V> sizeLimit(int sizeLimit) {
        this.sizeLimit = sizeLimit;
        return this;
    }

    /**
     * 驱除策略
     *
     * @since 0.0.2
     */
    private ICacheEvict<K, V> evict;

    private ICachePersist<K, V> persist;

    /**
     * 过期策略
     * 暂时不做暴露
     *
     * @since 0.0.3
     */
    private ICacheExpire<K, V> expire;

    @Override
    public ICache<K, V> expire(K key, long timeInMills) {
        return null;
    }

    @Override
    public ICache<K, V> expireAt(K key, long timeInMills) {
        return null;
    }

    @Override
    public ICacheExpire<K, V> expire() {
        return null;
    }

    @Override
    public List<ICacheRemoveListener<K, V>> removeListeners() {
        return List.of();
    }

    private List<ICacheRemoveListener<K, V>> removeListeners;

    public Cache<K, V> removeListeners(List<ICacheRemoveListener<K, V>> removeListeners) {
        this.removeListeners = removeListeners;
        return this;
    }

    @Override
    public List<ICacheSlowListener> slowListeners() {
        return List.of();
    }

    @Override
    public ICacheLoad<K, V> load() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return Set.of();
    }

    @Override
    public Collection<V> values() {
        return List.of();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return Set.of();
    }

    public Cache<K, V> map(Map<K, V> map) {
        this.map = map;
        return this;
    }

    public Cache<K, V> evict(ICacheEvict<K, V> cacheEvict) {
        this.evict = cacheEvict;
        return this;
    }

    /**
     * 获取持久化类
     *
     * @return 持久化类
     * @since 0.0.10
     */
    @Override
    public ICachePersist<K, V> persist() {
        return persist;
    }


    /**
     * 获取驱除策略
     *
     * @return 驱除策略
     * @since 0.0.11
     */
    @Override
    public ICacheEvict<K, V> evict() {
        return this.evict;
    }
}

