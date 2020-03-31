import java.util.function.Consumer;

public interface List<T> {
    public boolean insert(T data);

    public void traversal(Consumer<T> visist);
}
