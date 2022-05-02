package tp1;

public class Stack<T> {
    MySimpleLinkedList<T> list;

    public Stack() {
        this.list = new MySimpleLinkedList<T>();
    }

    public void push(T element) {
        this.list.insertFront(element);
    }

    public T pop() {
        return this.list.extractFront();
    }

    public T top() {
        return this.list.get(0);
    }

    public void reverse() {
        MySimpleLinkedList<T> listAux = new MySimpleLinkedList<T>();
        for (T element : this.list) {
            listAux.insertFront(element);
        }
        this.list = listAux;
    }

    @Override
    public String toString() {
        return this.list.toString();
    }

}
