package GraphTrav;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
  
    static void bfs(List<List<Integer>> adj, int s, boolean[] visited) {
      
        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.offer(s);

        while (!q.isEmpty()) {
          
            int curr = q.poll();
            System.out.print(curr + " ");
            for (int x : adj.get(curr)) {
                if (!visited[x]) {
                    visited[x] = true;
                    q.offer(x);
                }
            }
        }
    }

    static void addEdge(List<List<Integer>> adj,int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 4);

        boolean[] visited = new boolean[V];

        System.out.println("BFS starting from 0 : ");
        bfs(adj, 0, visited);
    }
}
