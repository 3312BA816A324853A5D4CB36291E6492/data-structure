import java.util.NoSuchElementException;

public class SequentialStack<T> extends SequentialList03 {
    public T push(T item) {
        this.insert(item);
        return item;
    }

    public T pop() {
        int len = this.size();
        T tmp = this.peek();
        this.remove(len - 1);
        return tmp;
    }

    public T peek() {
        int len = this.size();
        if (len == 0) {
            throw new NoSuchElementException();
        } else {
            return (T) this.get(len - 1);
        }
    }

    public boolean empty() {
        return this.size() == 0;
    }
}
