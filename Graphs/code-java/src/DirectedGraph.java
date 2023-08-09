import java.util.*;

public class DirectedGraph {
    private Map<Integer, List<Integer>> adjacencyList;

    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new ArrayList<>());
        }
    }

    public void addEdge(int startVertex, int endVertex) {
        if (!adjacencyList.containsKey(startVertex)) {
            addVertex(startVertex);
        }

        if (!adjacencyList.containsKey(endVertex)) {
            addVertex(endVertex);
        }

        adjacencyList.get(startVertex).add(endVertex);
    }

    public List<Integer> getAdjacentVertices(int vertex) {
        return adjacencyList.get(vertex);
    }

    public int getVertexCount() {
        return adjacencyList.keySet().size();
    }

    public int getEdgeCount() {
        int count = 0;
        for (int vertex : adjacencyList.keySet()) {
            count += adjacencyList.get(vertex).size();
        }
        return count;
    }
}
