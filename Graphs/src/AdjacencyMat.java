
    //ADJACENCY MATRIX REPRESENTATION
    public class AdjacencyMat {
        private int[][] adjMatrix;
        private int numVertices;

        public AdjacencyMat(int numVertices) {
            this.numVertices = numVertices;
            this.adjMatrix = new int[numVertices][numVertices];
        }

        public void addEdge(int src, int dest) {
            this.adjMatrix[src][dest] = 1;
            this.adjMatrix[dest][src] = 1;
        }

        public void printGraph() {
            for (int i = 0; i < this.numVertices; i++) {
                System.out.print(i + ": ");
                for (int j = 0; j < this.numVertices; j++) {
                    System.out.print(this.adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            AdjacencyMat g = new AdjacencyMat(4);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 3);

            g.printGraph();
        }
    }

