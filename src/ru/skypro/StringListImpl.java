package ru.skypro;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] data = {};
    private int size = 0;
    private static int INITIAL_CAPACITY = 5;

    public StringListImpl() {
        this.data = new String[INITIAL_CAPACITY];
    }


    public String add(String item) {
        checkIfItemIsNotNull(item);
        checkIfArrayIsNotFull();
        data[size++] = item;
        return item;
    }

    public String add(int index, String item) {
        checkIfItemIsNotNull(item);
        checkIfArrayIsNotFull();
        checkIndex(index);
        System.arraycopy(data, index, data, index + 1, data.length - index);
        data[size++] = item;
        return item;
//        int j = 0;
//        for (int i = 0; i < size-1; i++) {
//            if(i == index) {
//                data[i] = item;
//            } else {
//                data [i] = data [j];
//                j++;
//            }
//        } return item;
    }

    @Override
    public String set(int index, String item) {
        checkIfItemIsNotNull(item);
        checkIndex(index);
        data[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        checkIfItemIsNotNull(item);
        checkIfItemExist(item);
        int index = indexOf(item);
        removeItem(index);
        return item;
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String item = get(index);
        removeItem(index);
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
        checkIndex(index);
        return data[index];
    }

    @Override
    public boolean equals(StringList differentList) {
        if (differentList == null) {
            return false;
        }
        if (size != differentList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals((differentList.get(i)))) {
                return false;
            }
        } return true;
    }

    private void removeItem(int index) {
        if (size - 1 > index) {
            System.arraycopy(data, index + 1, data, index, data.length - index);
        }
        data[--size] = null;
    }

    private void checkIfItemExist(String item) {
    }

    @Override
    public int size() {
        return size();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        data = new String[INITIAL_CAPACITY];
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(data, data.length);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    private void checkIfArrayIsNotFull() {
        if (size == data.length) {
            data = grow();
        }
    }

    private String[] grow() {
        return Arrays.copyOf(data, size * 2);
    }

    private void checkIfItemIsNotNull(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Item can't be null");
        }
    }

    public void printStringList() {
        System.out.print("StringList: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + ", ");
        }
    }
}
