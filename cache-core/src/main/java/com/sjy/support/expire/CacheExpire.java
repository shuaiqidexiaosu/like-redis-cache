package com.sjy.support.expire;

import com.github.houbb.heaven.util.util.MapUtil;
import com.sjy.api.ICache;
import com.sjy.api.ICacheExpire;
import com.sjy.api.ICacheRemoveListener;
import com.sjy.api.ICacheRemoveListenerContext;
import com.sjy.constant.CacheRemoveType;
import com.sjy.support.listener.remove.CacheRemoveListenerContext;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class CacheExpire<K, V> implements ICacheExpire<K, V> {


    private static final int LIMIT = 100;

    /**
     * 过期 map
     * <p>
     * 空间换时间
     *
     * @since 0.0.3
     */
    private final Map<K, Long> expireMap = new HashMap<>();

    /**
     * 缓存实现
     *
     * @since 0.0.3
     */
    private final ICache<K, V> cache;

    private static final ScheduledExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadScheduledExecutor();


    public CacheExpire(ICache<K, V> cache) {
        this.cache = cache;
        this.init();
    }

    private void init() {
        EXECUTOR_SERVICE.scheduleAtFixedRate(new)
    }

    private class ExpireThread implements Runnable {

        @Override
        public void run() {
            if (MapUtil.isEmpty(expireMap)) {
                return;
            }
            int count = 0;
            for (Map.Entry<K, Long> entry : expireMap.entrySet()) {
                if (count > LIMIT) {
                    return;
                }
                expireKey(entry.getKey(), entry.getValue());
                count++;
            }
        }
    }

    private void expireKey(final K key, final Long expireAt) {
        if (expireAt == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (expireAt > currentTimeMillis) {
            expireMap.remove(key);
            V removeValue = cache.remove(key);
            ICacheRemoveListenerContext<K, V> removeListenerContext = CacheRemoveListenerContext.<K, V>newInstance().key(key).value(removeValue).type(CacheRemoveType.EXPIRE.code());
            for (ICacheRemoveListener<K, V> listener : cache.removeListeners()) {
                listener.listen(removeListenerContext);
            }
        }
    }

    @Override
    public void expire(K key, long expire) {

    }

    @Override
    public void refreshExpire(K key, V value, Collection<K> keyList) {

    }

    @Override
    public Long expireTime(K key) {
        return 0L;
    }
}
