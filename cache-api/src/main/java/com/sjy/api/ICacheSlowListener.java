package com.sjy.api;

public interface ICacheSlowListener {

    /**
     * 监听
     *
     * @param context 上下文
     * @since 0.0.6
     */
    void listen(final ICacheSlowListenerContext context);

    /**
     * 慢日志的阈值
     *
     * @return 慢日志的阈值
     * @since 0.0.9
     */
    long slowerThanMills();

}
