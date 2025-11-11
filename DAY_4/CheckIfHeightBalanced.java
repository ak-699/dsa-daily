package DAY_4;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class CheckIfHeightBalanced {
    public static boolean isHeightBalanced(Node root) {
        if (root == null)
            return true;
        boolean ilb = isHeightBalanced(root.left);
        boolean irb = isHeightBalanced(root.right);
        return ilb && irb && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.left.left = new Node(2);
        System.out.println("Is height balanced: " + isHeightBalanced(root));
    }
}
