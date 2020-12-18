package main.logica.nivel.oleada_enemigos.entry;

import java.util.Map.Entry;

public class EntryImpl<K, V> implements Entry<K, V> {

    private K key;
    private V value;

    public EntryImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V oldValue = this.value;
        this.value = value;

        return oldValue;
    }

    /**
     * Rempleza la key de esta entry por la key parametrizada.
     * @param key La nueva key que tendra esta entry.
     * @return La key que poseia anteriormete esta entry.
     */
    public K setKey(K key) {
        K oldKey = this.key;
        this.key = key;

        return oldKey;
    }
    
}
