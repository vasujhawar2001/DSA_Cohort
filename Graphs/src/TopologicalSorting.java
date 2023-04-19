import java.util.*;

public class TopologicalSorting {

    public static List<Integer> topologicalSort(int numVertices, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited, stack);
            }
        }

        List<Integer> sorted = new ArrayList<>();
        while (!stack.isEmpty()) {
            sorted.add(stack.pop());
        }

        return sorted;
    }

    private static void dfs(int node, List<List<Integer>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited, stack);
            }
        }

        stack.push(node);
    }

}
