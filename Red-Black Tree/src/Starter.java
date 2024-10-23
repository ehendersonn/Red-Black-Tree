public class Starter {

    public static void main(String[] args) {
        System.out.println("hello world");

        RBTree tree = new RBTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(30);
        tree.insert(2);

        System.out.println("Values in the Red-Black Tree: " + tree.toString());

    }
}
