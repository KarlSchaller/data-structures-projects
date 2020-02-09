import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {

        // YOUR CODE HERE
        boolean[] marked = new boolean[adj.length];
        int count = 0;
        for (int i = 0; i < adj.length; i++) { // use dfs to mark each component and count
            if (!marked[i]) {
                count++;
                dfs(adj, i, marked);
            }
        }

        return count;
    }

    // feel free to add a helper method to make your code cleaner & modular.

    private static void dfs(ArrayList<Integer>[] adj, int v, boolean[] marked) {

        marked[v] = true;
        for (int i : adj[v]) {
            if (!marked[i])
                dfs(adj, i, marked);
        }
    }


    public static void main(String[] args) {
        In in = new In("G2-3.txt");
        int n = in.readInt();
        int m = in.readInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = in.readInt();
            y = in.readInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

