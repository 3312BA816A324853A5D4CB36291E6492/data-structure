import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LinkedListv01<T> implements Iterable<T> {
    private Node head;

    LinkedListv01() {
        head = null;
    }

    public class Node {
        private T data;
        private Node next;

        Node(T d) {
            this.data = d;
        }
    }

    public void insert(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
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
