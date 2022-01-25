package ru.skypro;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 7;

    public StringListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public StringListImpl(int capacity) {
        this.data = new String[capacity];
    }

    @Override
    public String add(String item) {
        checkIfItemIsNotNull(item);
        checkIfArrayIsNotFull();
        data[size++] = item;
        return item;
    }

    @Override
    public String addWithIndex( int index, String item) {
        checkIfItemIsNotNull(item);
        checkIfArrayIsNotFull();
        checkIfIndexIsValid(index);
        if (index < size) {
            for (int temp = size+1; temp > index; temp --) {
                data[temp] = data[temp - 1];
            } data [index] = item;
            size++;
            } else {
            data [size++] = item;
        } return item;
    }

    @Override
    public String set(int index, String item) {
        checkIfItemIsNotNull(item);
        checkIfIndexIsValid(index);
        data[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkIfItemIsNotNull(item);
        checkIfItemExist(item);
        for (int i = 0; i < size; i++) {
            if (data [i]. equals(item)) {
                return removeByIndex(i);
            }
        }
        return item;
    }

    @Override
    public String removeByIndex(int index) {
        checkIfIndexIsValid(index);
        String item = get(index);
        for (int i=index; i<size-1; i++) {
            data [i] = data [i+1];
        }
        data [size-1] = null;
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(String item) {
        checkIfItemIsNotNull(item);
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkIfItemIsNotNull(item);
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIfIndexIsValid(index);
        return data[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            return false;
        }
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals((otherList.get(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        data = new String[DEFAULT_CAPACITY];
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(data, data.length);
    }

    private void checkIfItemExist(String item) {
        if (indexOf(item) == -1) {
            throw new IllegalArgumentException("Item doesn't exist");
        }
    }

    private void checkIfIndexIsValid(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    private void checkIfArrayIsNotFull() {
        if (size == data.length) {
            data = grow();
        }
    }

    private void checkIfItemIsNotNull(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item can't be null");
        }
    }
    private String[] grow() {
        return Arrays.copyOf(data, size * 2);
    }

    public void printStringList() {
        System.out.print("StringList: ");
        for (int i = 0; i < size ; i++) {
            System.out.print(data[i] + " ");
        }
            System.out.println();
    }
}
