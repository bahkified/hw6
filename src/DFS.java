
/**
 * Author by flo on 10/25/15.
 * Project Num : Project 5
 * Purpose     : To demonstrate the use
 * Algorithm   :
 *             :
 *             :
 *             :
 *             :
 * Compile     :
 *             :
 *             http://krishnalearnings.blogspot.in/search/label/Depth%20first%20search
 *
 */


public class DFS {

    private int[][] adjacencyMatrix;
    private int size; // number of nodes in the graph
    private boolean[] visited;

    public DFS(int size) {
        this.size = size;
        adjacencyMatrix = new int[size][size];// Initialized with all 0s
        visited = new boolean[size];
    }

    public void addEdge(int sourceName, int destinationName) {
        int sourceIndex = sourceName - 1;
        int destinationIndex = destinationName - 1;
        adjacencyMatrix[sourceIndex][destinationIndex] = 1;

        // the graph is non directional so if from S, D is reachable then vice
        // versa is also true
        adjacencyMatrix[destinationIndex][sourceIndex] = 1;
    }

   /*
    * If graph contains disconnected nodes or sub graphs then below loops
    * makes sure that all such nodes or sub graphs are also visited
    *
    * In a single connected graph below loop is not needed and simply
    * dfs(1); can be called and the graph will be visited.
    */

    public void traverseGraph() {
        System.out.println("Using DFS Traversing the graph");
        for (int i = 1; i <= size; i++) {
            if (!visited[i - 1]) {
                dfs(i);
            }
        }
    }

    private void dfs(int currentNodeName) {
        visited[currentNodeName - 1] = true;
        System.out.println(currentNodeName);
        for (int i = 0; i < size; i++) {
            if (adjacencyMatrix[currentNodeName - 1][i] != 0) {
                if (!visited[i]) {
                    dfs(i + 1);
                }
            }
        }
    }
}