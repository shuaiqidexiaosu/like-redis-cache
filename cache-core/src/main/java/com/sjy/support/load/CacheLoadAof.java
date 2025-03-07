package com.sjy.support.load;

import com.alibaba.fastjson.JSON;
import com.github.houbb.heaven.util.io.FileUtil;
import com.github.houbb.heaven.util.lang.StringUtil;
import com.github.houbb.heaven.util.lang.reflect.ReflectMethodUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.github.houbb.log.integration.core.Log;
import com.github.houbb.log.integration.core.LogFactory;
import com.sjy.annotation.CacheInterceptor;
import com.sjy.api.ICache;
import com.sjy.api.ICacheLoad;
import com.sjy.core.Cache;
import com.sjy.model.PersistAofEntry;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheLoadAof<K, V> implements ICacheLoad<K, V> {

    private static final Log log = LogFactory.getLog(CacheLoadAof.class);

    private static final Map<String, Method> METHOD_MAP = new HashMap<>();


    static {
        Method[] methods = Cache.class.getMethods();

        for (Method method : methods) {
            CacheInterceptor cacheInterceptor = method.getAnnotation(CacheInterceptor.class);
            if (cacheInterceptor != null && cacheInterceptor.aof()) {
                METHOD_MAP.put(method.getName(), method);
            }

        }
    }

    private final String dbPath;

    public CacheLoadAof(String dbPath) {
        this.dbPath = dbPath;
    }

    @Override
    public void load(ICache<K, V> cache) {
        List<String> lines = FileUtil.readAllLines(dbPath);
        log.info("load 开始处理 aof 文件: {}", dbPath);
        if (CollectionUtil.isEmpty(lines)) {
            log.info("[load] path: {} 文件内容为空，直接返回", dbPath);
            return;
        }

        for (String line : lines) {
            if (StringUtil.isEmpty(line)) {
                continue;
            }

            // 执行
            // 简单的类型还行，复杂的这种反序列化会失败
            PersistAofEntry entry = JSON.parseObject(line, PersistAofEntry.class);

            final String methodName = entry.getMethodName();
            final Object[] objects = entry.getParams();

            final Method method = METHOD_MAP.get(methodName);
            // 反射调用
            ReflectMethodUtil.invoke(cache, method, objects);
        }

    }
}
