import org.junit.Assert;
import org.junit.Test;
import java.util.Iterator;

public class SequentialList02Test {
    @Test
    public void foo() {
        SequentialList02<Integer> list = new SequentialList02<>(5);

        final int N = 5;
        for (int i = 0; i < N; i++) {
            list.insert(i);
        }

        list.traversal((d) -> System.out.println(d));

        Integer n = 0;
        Iterator itr = list.iterator();
        for (Integer x : list) {
            Assert.assertEquals(x, n++);
        }
        Assert.assertTrue(n == 5);
    }

}
