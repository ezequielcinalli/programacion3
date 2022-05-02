package tp1;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();

        lista.insertFront(3);
        lista.insertFront(2);
        lista.insertFront(1);
        lista.insertFront(5);

        Iterator<Integer> it1 = lista.iterator();
        while (it1.hasNext()) {
            int valor = it1.next();
            System.out.println(valor);
        }

        System.out.println(lista.indexOf(5));
        System.out.println(lista.indexOf(3));
        System.out.println(lista.indexOf(81));

        // System.out.println(lista.toString());

        // Stack<Integer> stack = new Stack<Integer>();
        // stack.push(15);
        // stack.push(35);
        // stack.push(5);
        // System.out.println(stack.toString());
        // stack.reverse();
        // System.out.println(stack.toString());
    }

}
