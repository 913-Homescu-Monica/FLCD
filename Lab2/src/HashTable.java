import java.util.ArrayList;

public class HashTable<T> {
    private final int capacity;
    private final ArrayList<ArrayList<T>> hashTable;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.hashTable = new ArrayList<>();
        for (int i = 0; i < capacity; i++)
            this.hashTable.add(new ArrayList<>());
    }

    public int hash(T key) {
        if (key instanceof Integer)
            return ((Integer) key) % capacity;
        else
            return Math.abs(key.hashCode()) % capacity ;
    }

    public void add(T key) {
        int hashIndex = hash(key);
        if (!hashTable.get(hashIndex).contains(key))
            hashTable.get(hashIndex).add(key);
    }

    public int search(T key) {
        int hashIndex = hash(key);
        if (hashTable.get(hashIndex).contains(key))
            return hashIndex;
        return -1;
    }

    @Override
    public String toString() {
        return "HashTable - " + hashTable ;
    }
}
