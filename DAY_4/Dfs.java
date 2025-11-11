package DAY_4;

import java.util.ArrayList;
import java.util.List;

public class Dfs {
    public static void doTraversal(List<List<Integer>> adj) {
        int V = adj.size();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj);
            }
        }
    }

    private static void dfs(int i, boolean[] vis, List<List<Integer>> adj) {
        vis[i] = true;
        System.out.println(i);
        for (var val : adj.get(i)) {
            if (!vis[val]) {

                dfs(val, vis, adj);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(List.of(1));
        adj.add(List.of(2));
        adj.add(List.of(3));
        adj.add(List.of());
        doTraversal(adj);
    }
}
