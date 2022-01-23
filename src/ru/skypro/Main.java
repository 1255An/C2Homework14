package ru.skypro;

public class Main {

    public static void main(String[] args) {
        StringList list = new StringListImpl();
        list.add("a");
        list.add("b");
        list.add("c");

        ((StringListImpl) list).printStringList ();
    }
}
