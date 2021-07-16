package Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Table<K extends Comparable<K>, V extends Comparable<V>> {
    private List<Item<K, V>> items;

    public Table() throws IllegalArgumentException {
        items = new ArrayList<>();
    }

    public List<Item<K, V>> getItems() {
        return items;
    }

    public void put(K key, V value) throws IndexOutOfBoundsException {
        items.add(new Item<>(key, value));
    }

    public void sort() {
        Sort.mergeWithInsertion(getItems(), null, 0, getItems().size() - 1);
    }

    public void sort(Comparator<Item<K, V>> comparator) {
        Sort.merge(getItems(), null, 0, getItems().size() - 1, comparator);
    }

    public void sortByKey() {
        if (items.size() > 0) {
            this.sort(items.get(0).keyComparator());
        }
    }

    public void sortByValue() {
        if (items.size() > 0) {
            this.sort(items.get(0).valueComparator());
        }
    }

    @Override
    public String toString() {
        return "Table{" +
                "items=" + items +
                '}';
    }
}
