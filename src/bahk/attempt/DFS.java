package bahk.attempt;

/**
 * Do depth-first search
 */
public class DFS {

    public static void main(String[] args) throws Exception {
        Graph g = DataParser.parse();
        if (g == null) {
            System.err.println("No graph.");
            System.exit(1);
        }

        doDFS(g);
    }

    private static void doDFS(Graph graph) {
        runDFS(graph.get(1), graph, 0);
    }

    private static void runDFS(Node node, Graph graph, int c) {
        if (node == null) {
            return;
        }

        node.state = Node.State.VISITED;
        StateColor.assignColor(node, graph);

        for (int neighbor : node.neighbors) {
            Node nextNode = graph.get(neighbor);
            if (nextNode.state == Node.State.NEW) {
                runDFS(nextNode, graph, c);
            }
        }

        System.out.println(node.id + " :: " + node.name + " (" + node.color + ")");
    }

}
