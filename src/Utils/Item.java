package Utils;

import java.util.Comparator;

public class Item<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Item<K, V>> {
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

    public Comparator<Item<K, V>> keyComparator() {
        return (new Comparator<Item<K, V>>() {
            @Override
            public int compare(Item<K, V> itemA, Item<K, V> itemB) {
                return itemA.getKey().compareTo(itemB.getKey());
            }
        });
    }

    public Comparator<Item<K, V>> valueComparator() {
        return (new Comparator<Item<K, V>>() {
            @Override
            public int compare(Item<K, V> itemA, Item<K, V> itemB) {
                return itemA.getValue().compareTo(itemB.getValue());
            }
        });
    }

    @Override
    public int compareTo(Item<K, V> item) {
        return (this.getKey().compareTo(item.getKey()) + this.getValue().compareTo(item.getValue()));
    }

    @Override
    public String toString() {
        return "Item{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
