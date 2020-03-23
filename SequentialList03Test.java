import org.junit.Assert;
import org.junit.Test;
import java.util.Iterator;

public class SequentialList03Test {
    @Test
    public void foo() {
        SequentialList03<Integer> list = new SequentialList03<>(6);

        final int N = 5;
        for (int i = 0; i < N; i++) {
            list.insert(i);
        }

        Integer n = 0;
        Iterator itr = list.iterator();
        for (Integer x : list) {
            Assert.assertEquals(x, n++);
        }
        Assert.assertTrue(n == 5);


        list.set(0, 22);
        int a1 = list.get(0);
        Assert.assertEquals(a1, 22);

        list.insert(1, 22);
        int a2 = list.get(1);
        Assert.assertEquals(a2, 22);

        System.out.println(list.contains(22));
        System.out.println();

        list.traversal((d) -> System.out.println(d));
        System.out.println();

        System.out.println(list.removeAll(22));
    }

}
