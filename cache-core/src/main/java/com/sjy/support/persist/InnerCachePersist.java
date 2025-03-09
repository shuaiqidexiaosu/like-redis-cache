package com.sjy.support.persist;

import com.github.houbb.log.integration.core.Log;
import com.github.houbb.log.integration.core.LogFactory;
import com.sjy.api.ICache;
import com.sjy.api.ICachePersist;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class InnerCachePersist<K, V> {

    private static final Log log = LogFactory.getLog(InnerCachePersist.class);

    private final ICache<K, V> cache;

    private final ICachePersist<K, V> persist;

    private static final ScheduledExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadScheduledExecutor();

    public InnerCachePersist(ICache<K, V> cache, ICachePersist<K, V> cachePersist) {
        this.cache = cache;
        this.persist = cachePersist;
        this.init();
    }

    private void init() {
        EXECUTOR_SERVICE.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    log.info("开始持久化缓存信息");
                    persist.persist(cache);
                    log.info("完成持久化缓存信息");
                } catch (Exception exception) {
                    log.error("文件持久化异常", exception);
                }
            }
        }, persist.delay(), persist.period(), persist.timeUnit());
    }

}
