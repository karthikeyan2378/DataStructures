package Leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
/* Implement LRU CACHE using LinkedHashmap , override removeEldestEntry method
* */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private  int capacity;

    public LRUCache(int initialCapacity, int capacity) {
        super(initialCapacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
    public void put(int key, int value) {
        super.put(key, value);
    }
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
}
