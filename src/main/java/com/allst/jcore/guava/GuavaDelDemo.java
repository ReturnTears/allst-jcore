package com.allst.jcore.guava;

import com.google.common.cache.*;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author June
 * @since 2022-03-23
 */
public class GuavaDelDemo {
    public static void main(String[] args) throws ExecutionException {
        // CacheLoader的方式创建
        LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
                // 最大个数
                .maximumSize(3)
                // 移除通知
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
                        System.out.println(removalNotification.getKey() + " : " + removalNotification.getCause());
                    }
                })
                .build(new CacheLoader<String, Object>() {
            // 读取数据
            @Override
            public Object load(String key) throws Exception {
                return Constants.hm.get(key);
            }
        });
        // 初始化缓存
        initCache(cache);

        System.out.printf("cache size is %d%n", cache.size());

        // 显示缓存
        display(cache);

        // 读取key为5的缓存, FIFO
        get("5", cache);
        System.out.println("--------------------------------");
        display(cache);
    }

    /**
     * 初始化缓存
     */
    public static void initCache(LoadingCache<String, Object> cache) throws ExecutionException {
        for (int i = 1; i < 5; i++) {
            cache.get(String.valueOf(i));
        }
    }

    /**
     * 显示缓存
     */
    public static void display(LoadingCache<String, Object> cache) {
        for (Map.Entry<String, Object> stringObjectEntry : cache.asMap().entrySet()) {
            System.out.println(stringObjectEntry.toString());
        }
    }

    /**
     * 读取缓存数据， 如果没有则回调数据源并写入缓存
     */
    public static void get(String key, LoadingCache<String, Object> cache) throws ExecutionException {
        cache.get(key, new Callable<Object>() {
            // 回调方法用于读取数据并写入缓存
            @Override
            public Object call() throws Exception {
                // 读取数据
                String s = Constants.hm.get(key);
                // 写回缓存
                cache.put(key, s);
                return s;
            }
        });
    }
}
