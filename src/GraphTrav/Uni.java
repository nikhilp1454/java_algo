package GraphTrav;

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    public boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) {
            return false;
        }

        if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }

        return true;
    }
}

public class Uni {
    private int V;
    private int[][] edges;

    public Uni(int V, int[][] edges) {
        this.V = V;
        this.edges = edges;
    }

    public boolean hasCycle() {
        UnionFind unionFind = new UnionFind(V);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (!unionFind.union(u, v)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3}
        };

        Uni uni = new Uni(V, edges);

        if (uni.hasCycle()) {
            System.out.println("Graph contains a cycle");
        } else {
            System.out.println("Graph does not contain a cycle");
        }
    }
}
