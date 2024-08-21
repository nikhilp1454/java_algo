package Computational;

import java.util.Arrays;
public class SalesManTravelMST {
   static final int V = 6; 
   static int findMinKey(int key[], boolean mstSet[]) {
      int min = Integer.MAX_VALUE;
      int minIndex = -1;
      for (int v = 0; v < V; v++) {
         if (!mstSet[v] && key[v] < min) {
            min = key[v];
            minIndex = v;
         }
      }
      
      return minIndex;
   }
   
   static void primMST(int graph[][], int parent[]) {
      int key[] = new int[V];
      boolean mstSet[] = new boolean[V];
      Arrays.fill(key, Integer.MAX_VALUE);
      Arrays.fill(mstSet, false);
      key[0] = 0;
      parent[0] = -1;
      for (int count = 0; count < V - 1; count++) {
         int u = findMinKey(key, mstSet);
         mstSet[u] = true;
         for (int v = 0; v < V; v++) {
            if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
               parent[v] = u;
               key[v] = graph[u][v];
            }
         }
      }
   }

   static void printPreorderTraversal(int parent[]) {
      System.out.print("The preorder traversal of the tree is found to be  ");
      for (int i = 1; i < V; i++) {
         System.out.print(parent[i] + " -> ");
      }
      System.out.println();
   }
   static void tspApproximation(int graph[][]) {
      int parent[] = new int[V];
      int root = 0; 
      
      primMST(graph, parent);

      printPreorderTraversal(parent);

      System.out.print("Adding the root node at the end of the traced path ");
      for (int i = 0; i < V; i++) {
         System.out.print(parent[i] + " -> ");
      }
      System.out.println(root + "  " + parent[0]);

      int cost = 0;
      for (int i = 1; i < V; i++) {
         cost += graph[parent[i]][i];
      }

      System.out.println("All costs in min spanning tree: " + cost);
   }
   public static void main(String[] args) {
      int graph[][] = {
         {0, 3, 1, 6, 0, 0},
         {3, 0, 5, 0, 3, 0},
         {1, 5, 0, 5, 6, 4},
         {6, 0, 5, 0, 0, 2},
         {0, 3, 6, 0, 0, 6},
         {0, 0, 4, 2, 6, 0}
      };
      
      tspApproximation(graph);
   }
}