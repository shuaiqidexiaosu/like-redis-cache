package com.sjy.api;

public interface ICacheRemoveListener<K, V> {
    void listen(final ICacheRemoveListenerContext<K, V> context);
}
