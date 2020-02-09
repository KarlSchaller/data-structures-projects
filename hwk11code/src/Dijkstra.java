import java.util.*;

public class Dijkstra {
    static class Node implements Comparator<Node> {
        public int vertex;
        public int cost;

        public Node() {}

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            return node1.cost - node2.cost;
        }
    }

    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        boolean[] marked = new boolean[adj.length];
        int[] distTo = new int[adj.length];
        Arrays.fill(distTo, -1);

        PriorityQueue<Node> queue = new PriorityQueue<>(adj.length, new Node());
        distTo[s] = 0;
        queue.add(new Node(s, distTo[s]));

        while (!queue.isEmpty()) {
            Node v = queue.remove();
            marked[v.vertex] = true;
            for (int w : adj[v.vertex]) {
                if (!marked[w]) {
                    int dist = v.cost + cost[v.vertex].get(adj[v.vertex].indexOf(w));
                    if (dist < distTo[w] || distTo[w] == -1) {
                        distTo[w] = dist;
                        queue.add(new Node(w, dist));
                    }
                }
            }
        }

        return distTo[t];
    }

    public static void main(String[] args) {
        In in = new In("G4-1.txt");
        int n = in.readInt();
        int m = in.readInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = in.readInt();
            y = in.readInt();
            w = in.readInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = in.readInt() - 1;
        int y = in.readInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}
