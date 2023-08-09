import java.util.*;

public class CompactEdgeList {

    static class Graph {
        int[] dest;     // array of destination vertices
        int[] next;     // array of next edge indices
        int[] head;     // array of first edge indices
        int numEdges;   // number of edges in the graph

        public Graph(int numVertices, int numEdges) {
            dest = new int[numEdges];
            next = new int[numEdges];
            head = new int[numVertices];
            Arrays.fill(head, -1);  // initialize all first edges to -1
            this.numEdges = 0;
        }

        public void addEdge(int source, int destination) {
            dest[numEdges] = destination;
            next[numEdges] = head[source];
            head[source] = numEdges;
            numEdges++;
        }

        public void printGraph() {
            for (int i = 0; i < head.length; i++) {
                System.out.print(i + ": ");
                for (int j = head[i]; j != -1; j = next[j]) {
                    System.out.print(dest[j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int numVertices = 4;
        int numEdges = 5;
        Graph graph = new Graph(numVertices, numEdges);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        graph.printGraph();
    }
}
