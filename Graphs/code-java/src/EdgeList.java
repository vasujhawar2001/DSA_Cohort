import java.util.ArrayList;
import java.util.List;

public class EdgeList {
    private int numVertices;
    private List<Edge> edgeList;

    public EdgeList(int numVertices) {
        this.numVertices = numVertices;
        this.edgeList = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        edgeList.add(new Edge(src, dest, weight));
        edgeList.add(new Edge(dest, src, weight)); // undirected graph
    }

    public void printGraph() {
        for (Edge edge : edgeList) {
            System.out.println(edge.src + " - " + edge.dest);
        }
    }

    private class Edge {
        private int src;
        private int dest;
        private int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        EdgeList g = new EdgeList(4);

        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 20);
        g.addEdge(1, 2, 30);
        g.addEdge(2, 3, 40);

        g.printGraph();
    }
}