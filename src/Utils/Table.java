package Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Table<K extends Comparable<K>, V> {
    private List<Item<K, V>> items;

    public Table() {
        items = new ArrayList<>();
    }

    public List<Item<K, V>> getItems() {
        return items;
    }

    public void put(K key, V value) {
        items.add(new Item<>(key, value));
    }

    public void sort() {
        Sort.quickWithInsertion(getItems(), 0, getItems().size() - 1, 15);
    }

    public void sort(Comparator<Item<K, V>> comparator) {
        Integer count = 0;
        Sort.quickSameSubdivision(getItems(), 0, getItems().size() - 1, 15, count);
    }

    @Override
    public String toString() {
        return "Table{" +
                "items=" + items +
                '}';
    }
}
