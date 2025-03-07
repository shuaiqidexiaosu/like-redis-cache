package com.sjy.api;

import java.util.Map;

/**
 * 缓存接口
 *
 * @author sjy
 * @date 2019/3/27
 */
public interface ICacheContext<K, V>  {
    Map<K, V> map();

    int size();


    ICacheEvict<K, V> cacheEvict();

}
