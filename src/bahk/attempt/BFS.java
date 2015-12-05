package bahk.attempt;

import bahk.attempt.Node.State;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Do a breadth first search of a graph.
 */
public class BFS {

    public static void main(String[] args) throws Exception {
        Graph g = DataParser.parse();
        if (g == null) {
            System.err.println("No graph.");
            System.exit(1);
        }
        doBFS(g);
    }

    private static void doBFS(Graph graph) {
        int c = 0;
        Queue<Integer> bfsQueue = new ArrayDeque<>();

        bfsQueue.add(graph.get(1).id);

        while (!bfsQueue.isEmpty()) {
            c++;
            Node visited = graph.get(bfsQueue.remove());
            visited.state = State.VISITED;
            StateColor.assignColor(visited, graph);

            System.out.println(visited.id + " :: " + visited.name + " (" + visited.color + ")");

            for (int neighbor : visited.neighbors) {
                Node next = graph.get(neighbor);
                if (next.state == State.NEW) {
                    bfsQueue.add(neighbor);
                    next.state = State.IN_Q;
                }
            }
        }

        // TODO: output must include the level #
        System.out.println("Total path length: " + c);
    }

}
