package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    private Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        if (load(key).equals("") || load(key) == null) {
            System.out.println("Achtung!");
            return;
        }
            SoftReference<V> valSoftRef = new SoftReference<>(value);
            cache.put(key, valSoftRef);
    }

    public V get(K key) {
        if (cache.get(key) == null || cache.get(key).get() == null) {
            put(key, load(key));
        }
        return cache.get(key) != null ? cache.get(key).get() : null;
    }

    protected abstract V load(K key);

}