package GraphTrav;

import java.util.*;

class Dijkstra {
    static final int V = 6;

    int minDistance(int dist[], Boolean sptSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int dist[]) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != 0
                    && dist[u] != Integer.MAX_VALUE
                    && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        printSolution(dist);
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] {
            { 0, 7, 9, 0, 0, 14 },
            { 7, 0, 10, 15, 0, 0 },
            { 9, 10, 0, 11, 0, 2 },
            { 0, 15, 11, 0, 6, 0 },
            { 0, 0, 0, 6, 0, 9 },
            { 14, 0, 2, 0, 9, 0 }
        };

        Dijkstra t = new Dijkstra();
        t.dijkstra(graph, 0);
    }
}
