package Utils;

import java.util.Comparator;

public class Item<K extends Comparable<K>, V> implements Comparable<Item<K, V>> {
    private K key;
    private V value;

    public Item(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int compareTo(Item<K, V> item) {
        return this.getKey().compareTo(item.getKey());
    }

    @Override
    public String toString() {
        return "Item{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
