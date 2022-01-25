package ru.skypro;

public class Main {

    public static void main(String[] args) {
        StringListImpl list = new StringListImpl();

        //add
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.printStringList();


        //add with index
        list.addWithIndex(2, "e");
        list.printStringList();

        //set
        list.set(1, "f");
        list.printStringList();

        //remove
        list.remove("c");
        list.printStringList();

        //remove by index
        list.removeByIndex(1);
        list.printStringList();

        //contains
        System.out.println("Is StringList contain input item: " + list.contains("c"));

        //index of
        System.out.println("Index of input item: " + list.indexOf("e"));

        //last index of
        System.out.println("Last index of input item: " + list.lastIndexOf("d"));

        //get
        System.out.println("Item in input index: " + list.get(1));

        //equals
        StringListImpl otherList = new StringListImpl();
        otherList.add("a");
        otherList.add("e");
        // otherList.add("d");
        System.out.println("Is List1 equals List2: " + list.equals(otherList));

        //size
        System.out.println("Size of list: " + list.size());

        //isEmpty
        System.out.println("Is list empty: " + list.isEmpty());

        //clear
        list.clear();
        list.printStringList();

        //to Array
        String [] array = list.toArray();
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
