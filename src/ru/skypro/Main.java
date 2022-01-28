package ru.skypro;

public class Main {

    public static void main(String[] args) {

        //findTheFastestSort
        /*
        Integer[] array1 = generateRandomArray();

        Integer[] array2 = array1.clone();

        Integer[] array3 = array1.clone();

        long start = System.currentTimeMillis();
        sortBubble(array1);
        System.out.println("Time of bubble sorting: " + (System.currentTimeMillis() - start));

        sortSelection(array2);
        System.out.println("Time of selection sorting: " + (System.currentTimeMillis() - start));

        sortInsertion(array3);
        System.out.println("Time of insertion sorting: " + (System.currentTimeMillis() - start));
    }

    public static Integer[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        Integer[] array = new Integer[100_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000) + 1000;
        }
        return array;
    }

    public static void sortBubble(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swapElements(array, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(array, i, minElementIndex);
        }
    }

    public static void sortInsertion(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    private static void swapElements(Integer[] array, int indexA, int indexB) {
        int tmp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tmp;
    }
         */

        //IntegerListDemo

        IntegerListImpl listInt = new IntegerListImpl();

        //add
        listInt.add(7);
        listInt.add(3);
        listInt.add(8);
        listInt.add(1);
        listInt.printIntegerList();

        //add with index
        listInt.addWithIndex(2, 5);
        listInt.addWithIndex(4, 10);
        listInt.printIntegerList();

        //set
        listInt.set(1, 6);
        listInt.printIntegerList();

        //remove
        listInt.remove(1);
        listInt.printIntegerList();

        //remove by index
        listInt.removeByIndex(1);
        listInt.printIntegerList();

        //sorting
        listInt.quickSort(0, listInt.size() - 1);
        System.out.print("Sorted list with quick sorting: ");
        listInt.printIntegerList();

        //contains
        System.out.println("Is IntegerList contain input item: " + listInt.contains(10));

        //index of
        System.out.println("Index of input item: " + listInt.indexOf(8));

        //last index of
        System.out.println("Last index of input item: " + listInt.lastIndexOf(8));

        //get
        System.out.println("Item in input index: " + listInt.get(1));

        //equals
        IntegerListImpl otherList = new IntegerListImpl();
        otherList.add(1);
        otherList.add(2);
        // otherList.add(3);
        System.out.println("Is List1 equals List2: " + listInt.equals(otherList));

        //size
        System.out.println("Size of list: " + listInt.size());

        //isEmpty
        System.out.println("Is list empty: " + listInt.isEmpty());

        //clear
        listInt.clear();
        listInt.printIntegerList();

        //to Array
        Integer[] array = listInt.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
