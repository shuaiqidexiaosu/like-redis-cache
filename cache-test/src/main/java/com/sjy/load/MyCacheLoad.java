package com.sjy.load;

import com.sjy.api.ICache;
import com.sjy.api.ICacheLoad;

public class MyCacheLoad implements ICacheLoad<String, String> {


    @Override
    public void load(ICache<String, String> cache) {
        cache.put("key1", "value1");
        cache.put("key2", "value2");
    }
}
