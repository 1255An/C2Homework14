package ru.skypro;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 7;

    public IntegerListImpl() {
        this(DEFAULT_CAPACITY);
    }

    public IntegerListImpl(int capacity) {
        this.data = new Integer[capacity];
    }

    @Override
    public Integer add(Integer item) {
        checkIfItemIsNotNull(item);
        checkIfArrayIsNotFull();
        data[size++] = item;
        return item;
    }

    @Override
    public Integer addWithIndex(int index, Integer item) {
        checkIfItemIsNotNull(item);
        checkIfArrayIsNotFull();
        checkIfIndexIsValid(index);
        if (index < size) {
            for (int temp = size + 1; temp > index; temp--) {
                data[temp] = data[temp - 1];
            }
            data[index] = item;
            size++;
        } else {
            data[size++] = item;
        }
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkIfItemIsNotNull(item);
        checkIfIndexIsValid(index);
        data[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        checkIfItemIsNotNull(item);
        checkIfItemExist(item);
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)) {
                return removeByIndex(i);
            }
        }
        return item;
    }

    @Override
    public Integer removeByIndex(int index) {
        checkIfIndexIsValid(index);
        Integer item = get(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return item;
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    swapElements(data, j, j + 1);
                }
            }
        }
    }

    private void swapElements(Integer[] data, int indexA, int indexB) {
        int tmp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = tmp;
    }

    @Override
    public boolean contains(Integer item) {
        int min = 0;
        int max = data.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == data[mid]) {
                return true;
            }

            if (item < data[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Integer item) {
        checkIfItemIsNotNull(item);
        for (int i = 0; i < size; i++) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkIfItemIsNotNull(item);
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIfIndexIsValid(index);
        return data[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
        data = new Integer[DEFAULT_CAPACITY];
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(data, data.length);
    }

    private void checkIfItemExist(Integer item) {
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

    private void checkIfItemIsNotNull(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Item can't be null");
        }
    }

    private Integer[] grow() {
        return Arrays.copyOf(data, size * 2);
    }

    public void printIntegerList() {
        //    System.out.print("IntegerList: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
