import java.util.*;
//Useful for Cycle Detection
public class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            return;
        }

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }
}

class Graph {
    int V, E;
    Edge[] edges;

    class Edge {
        int src, dest;
    }

    public Graph(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
        }
    }

    public int find(DisjointSet ds, int i) {
        int root = ds.find(i);
        while (root != i) {
            int next = ds.find(root);
            ds.parent[i] = root;
            i = root;
            root = next;
        }
        return root;
    }

    public void union(DisjointSet ds, int x, int y) {
        int xRoot = find(ds, x);
        int yRoot = find(ds, y);

        if (xRoot == yRoot) {
            return;
        }

        ds.union(xRoot, yRoot);
    }

    public boolean isCycle() {
        DisjointSet ds = new DisjointSet(V);

        for (int i = 0; i < E; i++) {
            int x = find(ds, edges[i].src);
            int y = find(ds, edges[i].dest);

            if (x == y) {
                return true;
            }

            union(ds, x, y);
        }

        return false;
    }
}

class Main {
    public static void main(String[] args) {
        int V = 3, E = 3;
        Graph graph = new Graph(V, E);

        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;

        graph.edges[1].src = 1;
        graph.edges[1].dest = 2;

        graph.edges[2].src = 2;
        graph.edges[2].dest = 0;

        if (graph.isCycle()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }
    }
}
