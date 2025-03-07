package com.sjy.api;

/**
 * 缓存明晰信息
 *
 * @author sjy
 * @date 2019/3/27
 */
public interface ICacheEntry<K, V> {

    K key();

    V value();

}
