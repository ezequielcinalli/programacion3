package tp1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T> {

    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info, null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }

    public T extractFront() {
        if (first == null)
            return null;
        Node<T> temp = first;
        this.size--;
        this.first = this.first.getNext();
        return temp.getInfo();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T get(int index) {
        int counter = 0;
        if (first == null || index >= this.size || index < 0) {
            return null;
        }
        Node<T> temp = first;
        while (temp != null && counter < index) {
            temp = temp.getNext();
            counter++;
        }
        if (temp == null)
            return null;
        return temp.getInfo();
    }

    public int size() {
        return this.size;
    }

    public int indexOf(T info) {
        int counter = 0;
        Node<T> temp = first;
        while (temp != null && counter < size) {
            if (temp.getInfo().equals(info))
                return counter;
            else {
                counter++;
                temp = temp.getNext();
            }
        }
        return -1;
    }

    public int indexOfRecursive(T info) {
        return this.recursiveIndexOf(info, first, 0);
    }

    private int recursiveIndexOf(T info, Node<T> first, int index) {
        if (first == null)
            return -1;
        else {
            if (first.getInfo().equals(info))
                return index;
            else
                return recursiveIndexOf(info, first.getNext(), index + 1);
        }
    }

    @Override
    public String toString() {
        String result = "";
        Node<T> temp = first;
        while (temp != null) {
            result += temp.getInfo();
            result += ",";
            temp = temp.getNext();
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator<T>(this.first);
    }

}
