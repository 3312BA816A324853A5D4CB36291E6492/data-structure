import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListv10Test {
    LinkedListv10<Integer> list = new LinkedListv10<>();

    @Test
    public void isEmpty() {
        Assert.assertTrue(list.isEmpty());

        final int N = 5;
        for (int i = 1; i <= N; i++) {
            list.insert(i);
        }

        assertFalse(list.isEmpty());
    }

    @Test
    public void get() {
        final int N = 5;
        for (int i = 1; i <= N; i++) {
            list.insert(i);
        }

        Integer n = 5;
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(list.get(i), n--);
        }

        assertEquals(0, (int) n);
    }

    @Test
    public void set() {
        final int N = 5;
        for (int i = 1; i <= N; i++) {
            list.insert(i);
        }

        int n = 1;
        for (int i = 0; i < 5; i++) {
            Assert.assertTrue(list.set(i, n++));
        }

        assertEquals(6, n);
    }

    @Test
    public void testInsert() {
        list.insert(0, 99);
        assertEquals(99, (int) list.get(0));
    }

    @Test
    public void remove() {
        Integer n = 5;
        for (int i = 1; i <= 5; i++) {
            list.insert(i);
        }

        for (int i = 0; i <= 4; i++) {
            assertEquals(list.remove(0), n--);
        }

        assertEquals(0, (int) n);
    }

    @Test
    public void removeAll() {
        for (int i = 1; i <= 5; i++) {
            list.insert(22);
        }

        int n = 5;
        assertEquals(list.removeAll(22), 5);
    }

    @Test
    public void contains() {
        for (int i = 1; i <= 5; i++) {
            list.insert(22);
        }

        int n = 5;
        assertEquals(list.contains(22), 5);
    }

    @Test
    public void traversal() {
        list.traversal((d) -> System.out.println(d));
    }
}
