package com.sjy.api;

public interface ICacheEvict<K, V> {

    /**
     * @param context
     * @return
     */
    ICacheContext<K, V> evict(final ICacheEvictContext<K, V> context);


    /**
     * description:
     *
     * @since: 1.0.0
     * @author: 作者拼音或者英文名称
     * @date: 2025/3/7 下午5:30
     * @Param key:
     * @return: void
     */
    void updateKey(final K key);

    /**
     * description: 删除key信息
     *
     * @since: 1.0.0
     * @author: 作者拼音或者英文名称
     * @date: 2025/3/7 下午5:30
     * @Param key:
     * @return: void
     */
    void removeKey(final K key);

}