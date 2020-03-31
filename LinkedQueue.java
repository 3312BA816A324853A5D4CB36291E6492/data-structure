public class LinkedQueue<T> extends LinkedListv10 {
    public T push(T item) {
        this.insert(item);
        return item;
    }

    public T pop() {
        int len = this.size();
        T tmp = (T) this.remove(len - 1);
        return tmp;
    }

    public T peek() {
        int len = this.size();
        T tmp = (T) this.get(len - 1);
        return tmp;
    }

    public boolean empty() {
        return this.size() == 0;
    }
}
