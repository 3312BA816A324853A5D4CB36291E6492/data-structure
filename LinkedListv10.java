import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LinkedListv10<T> implements Iterable<T> {
    private int size;
    private Node head;
    private Node tail;

    LinkedListv10() {
        size = 0;
        head = null;
        tail = null;
    }

    public class Node {
        private T data;
        private Node next;

        Node(T d) {
            this.data = d;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            Node tmp = head;

            for (int k = 0; k < index; k++) {
                tmp = tmp.next;
            }

            return tmp.data;
        }

        throw new NoSuchElementException();
    }

    public boolean set(int index, T data) {
        if (index >= 0 && index < size) {
            Node tmp = head;

            for (int k = 0; k < index; k++) {
                tmp = tmp.next;
            }

            tmp.data = data;

            return true;
        }

        return false;
    }

    public void insert(T data) {
        Node newNode = new Node(data);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    public void insert(int index, T data) {
        if (index == 0) {
            insert(data);
        } else if (index <= size) {
            Node newNode = new Node(data);
            Node pre = head;

            for (int k = 0; k < index - 1; k++) {
                pre = pre.next;
            }

            newNode.next = pre.next;
            pre.next = newNode;
            size++;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T remove(int index) {
        if (index == 0) {
            Node tmp = head;
            T d = tmp.data;
            head = head.next;
            tmp = null;
            return d;
        } else if (index > 0 && index < size){
            Node tmp = head;

            for (int k = 1; k < index; k++) {
                tmp = tmp.next;
            }

            T d = tmp.data;
            tmp.next = tmp.next.next;
            return d;
        }

        throw new NoSuchElementException();
    }

    public int removeAll(T data) {
        int count = 0;
        int index = 0;
        Node tmp = head;

        while (tmp != null) {
            if (tmp.data == data) {
                remove(index);
                index--;
                count++;
            }

            index++;
            tmp = tmp.next;
        }

        return count;
    }

    public int contains(T data) {
        int count = 0;

        for (Node i = head; i != null; i = i.next) {
            if (i.data == data) {
                count++;
            }
        }

        return count;
    }

    public void traversal(Consumer<T> visist) {
        for (Node i = head; i != null; i = i.next) {
            visist.accept(i.data);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T data = current.data;
                    current = current.next;
                    return data;
                }

                throw new NoSuchElementException();
            }
        };
    }
}
