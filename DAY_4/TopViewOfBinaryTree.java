package DAY_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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

public class TopViewOfBinaryTree {
    public static List<Integer> usingLevelOrderTraversal(Node root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        Map<Integer, Integer> mp = new TreeMap<>();
        q.offer(new Pair<>(root, 0));
        while (!q.isEmpty()) {
            Pair<Node, Integer> curr = q.poll();
            Node node = curr.first;
            Integer hd = curr.second;
            mp.putIfAbsent(hd, node.data);
            if (node.left != null)
                q.add(new Pair<>(node.left, hd - 1));
            if (node.right != null)
                q.add(new Pair<>(node.right, hd + 1));
        }
        for (var val : mp.keySet()) {
            result.add(mp.get(val));
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        System.out.println(usingLevelOrderTraversal(root));
    }
}
