public class DirectedGraphAdjMatrix {
    private int[][] adjMatrix;
    private int numVertices;

    public DirectedGraphAdjMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int source, int destination) {
        adjMatrix[source][destination] = 1;
    }

    public void removeEdge(int source, int destination) {
        adjMatrix[source][destination] = 0;
    }

    public boolean hasEdge(int source, int destination) {
        return adjMatrix[source][destination] == 1;
    }

    public void printGraph() {
        System.out.println("Directed Graph using Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
