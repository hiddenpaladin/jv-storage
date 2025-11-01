package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys = new Object[10];
    private Object[] values = new Object[10];

    public Object[] getKeys() {
        return keys;
    }

    public void setKeys(Object[] keys) {
        this.keys = keys;
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }

    @Override
    public void put(K key, V value) {
        int index = -1;
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(keys[i],key)) {
                index = i;
            }
        }
        if (index == -1) {
            //как то надо найти пустой кусок массива и туда записывать
            for (int i = 0; i < keys.length; i++) {
                if (keys[i] == null) {
                    keys[i] = key;
                    index = i;
                    break;
                }
            }
        }
        values[index] = value;
    }

    @Override
    public V get(K key) {
        int index = -1;
        for (int i = 0; i < keys.length; i++) {
            if (Objects.equals(keys[i],key)) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        }
        return (V)values[index];
    }

    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                size++;
            }
        }
        return size;
    }
}
