import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class SequentialList02<T> implements List<T>, Iterable<T>, Iterator<T> {
    private int size = 0;
    private int cursor = 0;
    private int capacity = 10;
    private Object[] array;

    public SequentialList02() {
        this.array = new Object[capacity];
    }

    public SequentialList02(int capacity) {
        this.array = new Object[capacity];
    }

    @Override
    public boolean insert(T data) {
        if (size < capacity) {
            this.array[size] = data;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

        size++;
        return true;
    }

    @Override
    public void traversal(Consumer<T> visist) {
        for (int i = 0; i < size; i++) {
            visist.accept((T) array[i]);
        }
    }

    @Override
    public Iterator<T> iterator() {
        cursor = 0;
        return this;
    }

    @Override
    public boolean hasNext() {
        return cursor < size;
    }

    @Override
    public T next() {
        if (hasNext()) {
            return (T) array[cursor++];
        }
        throw new NoSuchElementException();
    }
}
