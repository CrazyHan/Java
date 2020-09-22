package generic.generic_types02;

public class OrderedPair<K, V> implements Pair<K,V>{

    K k;

    V v;

    public OrderedPair(K k, V v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public K getKey() {
        return k;
    }

    @Override
    public V getValue() {
        return v;
    }
}
