package com.sjy.api;

import java.util.List;
import java.util.Map;

/**
 * 缓存接口
 *
 * @author sjy
 * @date 2019/3/27
 */
public interface ICache<K, V> extends Map<K, V> {

    ICache<K, V> expire(final K key, final long timeInMills);

    /**
     * 在指定的时间过期
     *
     * @param key         key
     * @param timeInMills 时间戳
     * @return this
     * @since 0.0.3
     */
    ICache<K, V> expireAt(final K key, final long timeInMills);

    /**
     * 获取缓存的过期处理类
     *
     * @return 处理类实现
     * @since 0.0.4
     */
    ICacheExpire<K, V> expire();

    /**
     * 删除监听类列表
     *
     * @return 监听器列表
     * @since 0.0.6
     */
    List<ICacheRemoveListener<K, V>> removeListeners();

    /**
     * 慢日志监听类列表
     *
     * @return 监听器列表
     * @since 0.0.9
     */
    List<ICacheSlowListener> slowListeners();

    /**
     * 加载信息
     *
     * @return 加载信息
     * @since 0.0.7
     */
    ICacheLoad<K, V> load();

    /**
     * 持久化类
     *
     * @return 持久化类
     * @since 0.0.10
     */
    ICachePersist<K, V> persist();

    /**
     * 淘汰策略
     *
     * @return 淘汰
     * @since 0.0.11
     */
    ICacheEvict<K, V> evict();


}
