import java.util.*;

class AdjacencyList {
    private int numVertices;
    private List<Integer>[] adjLists;

    public AdjacencyList(int vertices) {
        numVertices = vertices;
        adjLists = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjLists[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjLists[src].add(dest);
        adjLists[dest].add(src);
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print(i + ": ");
            for (int j : adjLists[i]) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyList g = new AdjacencyList(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        g.printGraph();
    }
}