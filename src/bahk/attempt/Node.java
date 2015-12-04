package bahk.attempt;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public enum State {
        NEW, IN_Q, VISITED
    }

    public final int id;
    public final String name;
    public final List<Integer> neighbors;

    public State state;

    public Node(String name, int id) {
        this.name = name;
        this.id = id;
        this.neighbors = new ArrayList<>();
        this.state = State.NEW;
    }

    public void addNeighbor(int nodeId) {
        neighbors.add(nodeId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (id != node.id) return false;
        if (name != null ? !name.equals(node.name) : node.name != null) return false;
        return neighbors.equals(node.neighbors);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + neighbors.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Node{" + "id=" + id + ", name='" + name + '\'' + ", neighbors=" + neighbors + '}';
    }
}
