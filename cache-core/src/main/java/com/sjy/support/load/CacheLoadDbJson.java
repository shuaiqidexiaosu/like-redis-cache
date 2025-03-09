package com.sjy.support.load;

import com.alibaba.fastjson.JSON;
import com.github.houbb.heaven.util.io.FileUtil;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.log.integration.core.Log;
import com.github.houbb.log.integration.core.LogFactory;
import com.sjy.api.ICache;
import com.sjy.api.ICacheLoad;
import com.sjy.model.PersistRdbEntry;

import java.util.List;

public class CacheLoadDbJson<K, V> implements ICacheLoad<K, V> {

    private static final Log log = LogFactory.getLog(CacheLoadDbJson.class);

    private final String dbPath;

    public CacheLoadDbJson(String dbPath) {
        this.dbPath = dbPath;
    }

    @Override
    public void load(ICache<K, V> cache) {
        List<String> lines = FileUtil.readAllLines(dbPath);
        log.info("load cache from db, size: {}", lines.size());
        if (CollectionUtil.isEmpty(lines)) {
            log.info("[load] path: {} 文件内容为空，直接返回", dbPath);
            return;
        }
        for (String line : lines) {
            if (StringUtil.isEmpty(line)) {
                continue;
            }
            PersistRdbEntry<K, V> entry = JSON.parseObject(line, PersistRdbEntry.class);

            K key = entry.getKey();
            V value = entry.getValue();
            Long expire = entry.getExpire();
            cache.put(key, value);
            if (ObjectUtil.isNotNull(expire)) {
                cache.expireAt(key, expire);
            }
        }

    }
}
