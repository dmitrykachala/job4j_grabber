package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    private Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        SoftReference<V> valSoftRef = new SoftReference<>(value);
        cache.put(key, valSoftRef);
    }

    public V get(K key) {
        SoftReference<V> valueReference = cache.get(key);
        return valueReference != null ? valueReference.get() : null;
    }

    protected abstract V load(K key);

}