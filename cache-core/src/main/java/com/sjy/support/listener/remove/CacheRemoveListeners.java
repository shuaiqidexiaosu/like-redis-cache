package com.sjy.support.listener.remove;

import com.sjy.api.ICacheRemoveListener;

import java.util.ArrayList;
import java.util.List;

public class CacheRemoveListeners {
    private CacheRemoveListeners() {
    }

    /**
     * description:
     *
     * @since: 1.0.0
     * @author: 作者拼音或者英文名称
     * @date: 2025/3/7 下午11:20
     * @return: java.util.List<com.sjy.api.ICacheRemoveListener < K, V>>
     */
    public static <K, V> List<ICacheRemoveListener<K, V>> defaults() {
        ArrayList<ICacheRemoveListener<K, V>> listeners = new ArrayList<>();
        listeners.add(new CacheRemoveListener());
        return listeners;

    }
}
