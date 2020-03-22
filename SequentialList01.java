public class SequentialList01<T> {
    private int size = 0;
    private int capacity = 10;
    private Object[] array;

    public SequentialList01() {
        this.array = new Object[capacity];
    }

    public SequentialList01(int capacity) {
        this.array = new Object[capacity];
    }

    public boolean insert(T data) {
        if (size < capacity && size >= 0) {
            this.array[size] = data;
        } else {
            return false;
        }

        size++;
        return true;
    }

    public void traversal() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }
}

