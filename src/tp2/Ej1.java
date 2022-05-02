package tp2;

import tp1.MySimpleLinkedList;

public class Ej1 {

    // MySimpleLinkedList<Integer> list1 = new MySimpleLinkedList<Integer>();
    // list1.insertFront(1);
    // list1.insertFront(3);
    // list1.insertFront(5);

    // System.out.println(Ej1.listIsOrder(list1));
    public static void main(String[] args) {
        int[] array1 = { 15, 7, 1, 8, 9, 12, 57, 43 };
        int[] array2 = { 5, 8, 12, 17, 21, 26 };
        int[] array3 = { 5, 8, 12 };
        System.out.println(Ej1.arrayIsOrder(array1, 0));
        System.out.println(Ej1.arrayIsOrder(array2, 0));
        System.out.println(Ej1.arrayIsOrder(array3, 0));
    }

    public static boolean arrayIsOrder(int[] array, int pos) {
        if (pos + 1 >= array.length) {
            return true;
        } else {
            if (array[pos] < array[pos + 1]) {
                return arrayIsOrder(array, pos + 1);
            }
            return false;
        }
    }

    public static boolean listIsOrder(MySimpleLinkedList<Integer> list) {

        // if (pos + 1 >= list.length) {
        // return true;
        // } else {
        // if (list[pos] < list[pos + 1]) {
        // return listIsOrder(list);
        // }
        // return false;
        // }

        return false;
    }
}
