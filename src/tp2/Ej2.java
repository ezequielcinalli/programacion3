package tp2;

import tp1.MySimpleLinkedList;

public class Ej2 {

    public static void main(String[] args) {

        MySimpleLinkedList<Integer> list1 = new MySimpleLinkedList<Integer>();
        list1.insertFront(1);
        list1.insertFront(3);
        list1.insertFront(5);

        // System.out.println(list1.toString());
        // System.out.println();

        // System.out.println(list1.indexOfRecursive(8));
        // System.out.println(list1.indexOfRecursive(1));
        // System.out.println(list1.indexOfRecursive(3));
        // System.out.println(list1.indexOfRecursive(5));

        int[] array1 = { 5, 10, 15, 20 };

        System.out.println(Ej2.searchInArrayOrdered(array1, 5, 0, array1.length - 1));
    }

    public static int searchInArrayOrdered(int[] array, int value, int start, int end) {
        int medio;
        if (end < start)
            return -1;
        else {
            medio = (start + end) / 2;
            if (array[medio] == value)
                return medio;
            else if (array[medio] < value)
                return searchInArrayOrdered(array, value, medio + 1, end);
            else
                return searchInArrayOrdered(array, value, start, medio - 1);
        }
    }

}
