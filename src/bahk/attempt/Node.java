package bahk.attempt;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public final String name;
    public final int id;
    public final List<Node> neighbors;

    public Node(String name, int id) {
        this.name = name;
        this.id = id;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;

        Node node = (Node) o;

        if (id != node.id) return false;
        if (name != null ? !name.equals(node.name) : node.name != null) return false;
        return !(neighbors != null ? !neighbors.equals(node.neighbors) : node.neighbors != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (neighbors != null ? neighbors.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Node{" + "name='" + name + '\'' + ", id=" + id + ", neighbors=" + neighbors + '}';
    }
}
