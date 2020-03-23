import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class SequentialList03<T> implements List<T>, Iterable<T>, Iterator<T> {
    private int size = 0;
    private int cursor = 0;
    private int capacity = 10;
    private Object[] array;

    public SequentialList03() {
        this.array = new Object[capacity];
    }

    public SequentialList03(int capacity) {
        this.array = new Object[capacity];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T get(int index) {
        if (index >= 0 && index < this.size) {
            return (T) array[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public boolean set(int index, T data) {
        if (index >= 0 && index < size) {
            array[index] = data;
            return true;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T remove(int index) {
        if (index >= 0 && index <= this.size) {
            T old = (T) array[index];

            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }

            size--;
            return old;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int removeAll(T data) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                remove(i);
                i--;
                count++;
            }
        }

        return count;
    }

    public int contains(T data) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                count++;
            }
        }

        return count;
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

    public boolean insert(int index, T data) {
        if (index >= 0 && index <= this.size && size - 1 < capacity) {
            for (int j = size; j > index; j--) {
                array[j] = array[j - 1];
            }

            array[index] = data;
            size++;
            return true;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
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
