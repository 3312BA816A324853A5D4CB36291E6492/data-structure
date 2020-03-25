import org.junit.Assert;
import org.junit.Test;

public class LinkedListv01Test {
    @Test
    public void foo() {
        LinkedListv01<Integer> list = new LinkedListv01<>();

        final int N = 5;
        for (int i = 1; i <= N; i++) {
            list.insert(i);
        }

        Integer n = 5;
        for (Integer x : list) {
            Assert.assertEquals(x, n--);
        }
        Assert.assertTrue(n == 0);

        list.traversal((d) -> System.out.println(d));
    }
}
