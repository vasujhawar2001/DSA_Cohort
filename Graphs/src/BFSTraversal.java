import java.util.*;
public class BFSTraversal
{
    private int nodes;       /* total number number of nodes in the graph */
    private LinkedList<Integer> adj[];      /* adjacency list */
    public BFSTraversal(int V)
    {
        nodes = V;
        adj = new LinkedList[nodes];
        for (int i=0; i<V; i++)
        {
            adj[i] = new LinkedList<>();
        }
;
    }
    void insertEdge(int v,int w)
    {
        adj[v].add(w);      /* adding an edge to the adjacency list (edges are bidirectional in this example) */
    }
    void BFS(int root)
    {
        boolean visited[] = new boolean[nodes];       /* initialize boolean array for holding the data */
        Queue<Integer>que = new LinkedList<Integer>();  //maintaining a queue
        int child = 0;
        visited[root]=true;
        que.add(root);       /* root node is added to the top of the queue */
        while (!que.isEmpty())
        {
            root = que.remove();        /* remove the top element of the queue */
            System.out.print(root+" ");    /* print the top element of the queue */
            for (int i = 0; i < adj[root].size(); i++)  /* iterate through the linked list and push all neighbors into queue */
            {
                child = adj[root].get(i);
                if (!visited[child])      /* only insert visited into queue if they have not been explored already */
                {
                    visited[child] = true;
                    que.add(child);
                }
            }
        }
    }
    public static void main(String args[])
    {
        BFSTraversal graph = new BFSTraversal(8);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(0, 3);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(3, 6);
        graph.insertEdge(4, 7);
        graph.insertEdge(4, 5);
        graph.insertEdge(5, 2);
        System.out.println("Breadth First Traversal for the graph is:");
        graph.BFS(0);
    }
}  