import java.util.Iterator;
import java.util.NoSuchElementException;

// Ex 9.4 (Intermediate)
public class MyLinkedList<T> implements Iterable<T> {

    // static nested: a Node needs no reference to the outer list object
    private static class Node<T> {
        final T value; Node<T> next;
        Node(T value) { this.value = value; }
    }

    private Node<T> head, tail;
    private int size;

    public void add(T value) {
        Node<T> n = new Node<>(value);
        if (head == null) head = tail = n; else { tail.next = n; tail = n; }
        size++;
    }
    public int size() { return size; }

    // inner (non-static): the iterator walks THIS list, so it uses the outer 'head' directly
    private class ListIterator implements Iterator<T> {
        private Node<T> current = head;
        public boolean hasNext() { return current != null; }
        public T next() {
            if (current == null) throw new NoSuchElementException();
            T v = current.value; current = current.next; return v;
        }
    }
    @Override public Iterator<T> iterator() { return new ListIterator(); }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("a"); list.add("b"); list.add("c");
        for (String s : list) System.out.print(s + " ");      // for-each works because we implement Iterable
        System.out.println("(size " + list.size() + ")");
    }
}
