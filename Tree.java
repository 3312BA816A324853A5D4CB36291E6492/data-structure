public class Tree<T> {
    private T data;
    private Tree<T> left;
    private Tree<T> right;

    Tree(T data) {
        this.data = data;
    }

    public void pre(Tree<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            pre(node.left);
            pre(node.right);
        }
    }

    public void mid(Tree<T> node) {
        if (node != null) {
            pre(node.left);
            System.out.print(node.data + " ");
            pre(node.right);
        }
    }

    public void pro(Tree<T> node) {
        if (node != null) {
            pre(node.left);
            pre(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        Tree<String> a = new Tree<>("A");
        Tree<String> b = new Tree<>("B");
        Tree<String> c = new Tree<>("C");
        Tree<String> d = new Tree<>("D");
        Tree<String> e = new Tree<>("E");
        Tree<String> f = new Tree<>("F");
        Tree<String> g = new Tree<>("G");
        Tree<String> h = new Tree<>("H");
        Tree<String> i = new Tree<>("I");

        a.left = b;
        b.left = d;
        d.right = g;
        a.right = c;
        c.left = e;
        c.right = f;
        e.left = h;
        e.right = i;

        System.out.println("先序遍历");
        a.pre(a);

        System.out.println();
        System.out.println("中序遍历");
        a.mid(a);

        System.out.println();
        System.out.println("后序遍历");
        a.pro(a);
    }
}
