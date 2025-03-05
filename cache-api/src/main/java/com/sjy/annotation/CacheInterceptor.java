package com.sjy.annotation;


import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheInterceptor {

    /**
     * 是否缓存
     * @return 默认开启缓存
     */
    boolean cache() default true;


    /**
     * 是否启用刷新机制
     * @return 默认关闭刷新机制
     */
    boolean refresh() default false;

    /**
     * 是否启用AOF机制
     * @return 默认关闭AOF机制
     */
    boolean aof() default false;

    /**
     * 是否启用删除机制
     * @return 默认关闭删除机制
     */
    boolean evict() default false;
}
