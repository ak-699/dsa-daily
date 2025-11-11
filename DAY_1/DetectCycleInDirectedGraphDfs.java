package DAY_1;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleInDirectedGraphDfs {
    public static boolean isCyclic(List<List<Integer>> adj) {
        int V = adj.size();
        boolean[] vis = new boolean[V];
        boolean[] inRecStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, vis, inRecStack, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int i, boolean[] vis, boolean[] inRecStack, List<List<Integer>> adj) {
        vis[i] = true;
        inRecStack[i] = true;
        for (var val : adj.get(i)) {
            if (!vis[val]) {
                if (dfs(val, vis, inRecStack, adj)) {
                    return true;
                }
            } else {
                if (inRecStack[val]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(List.of(1));
        adj.add(List.of(2));
        adj.add(List.of(3));
        adj.add(List.of(1));
        System.out.println("Is graph cyclic: " + isCyclic(adj));
    }
}
