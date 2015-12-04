package bahk.attempt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Graph {
    public final Map<Integer, Node> vertices;

    public Graph() {
        this.vertices = new HashMap<>();
    }

    public void addNodes(Node ... nodes) {
        if (nodes != null) {
            vertices.putAll(Arrays.asList(nodes).stream().collect(Collectors.toMap(e -> e.id, e -> e)));
        }
    }

    public void addEdge(int src, int dest) {
        vertices.get(src).addNeighbor(dest);
    }

    public Node get(int id) {
        return this.vertices.get(id);
    }
}
