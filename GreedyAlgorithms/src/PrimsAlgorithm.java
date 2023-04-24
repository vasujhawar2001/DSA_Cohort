import java.util.Arrays;

public class PrimsAlgorithm {

    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };
        int[] mst = primsAlgorithm(graph, 5);
        System.out.println("Minimum Spanning Tree: " + Arrays.toString(mst));
    }

    public static int[] primsAlgorithm(int[][] graph, int vertices) {
        int[] mst = new int[vertices];
        Arrays.fill(mst, -1);
        boolean[] visited = new boolean[vertices];
        visited[0] = true;
        for (int i = 1; i < vertices; i++) {
            int min = Integer.MAX_VALUE;
            int x = -1;
            int y = -1;
            for (int j = 0; j < vertices; j++) {
                if (visited[j]) {
                    for (int k = 0; k < vertices; k++) {
                        if (!visited[k] && graph[j][k] != 0 && graph[j][k] < min) {
                            min = graph[j][k];
                            x = j;
                            y = k;
                        }
                    }
                }
            }
            mst[y] = x;
            visited[y] = true;
        }
        return mst;
    }
}
