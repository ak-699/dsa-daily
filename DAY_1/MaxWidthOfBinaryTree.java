package DAY_1;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Pair<U, V> {
    U first;
    V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

public class MaxWidthOfBinaryTree {
    public static int usingLevelOrderTraversal(Node root) {
        if (root == null)
            return 0;
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        int minLeft = 0;
        int maxRight = 0;
        while (!q.isEmpty()) {
            Pair<Node, Integer> curr = q.poll();
            Integer hd = curr.second;
            Node node = curr.first;
            if (node.left != null) {
                minLeft = Math.min(minLeft, hd - 1);
                q.offer(new Pair<>(node.left, hd - 1));
            }
            if (node.right != null) {
                maxRight = Math.max(maxRight, hd + 1);
                q.offer(new Pair<>(node.right, hd + 1));
            }
        }
        return maxRight - minLeft;
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(4);
        System.out.println("Width of tree: " + usingLevelOrderTraversal(root));

    }
}
