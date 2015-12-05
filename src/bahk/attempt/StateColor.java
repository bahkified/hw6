package bahk.attempt;

import java.util.HashSet;
import java.util.Set;

public class StateColor {

    // Iterate through list of colors, assign first available color
    public static void assignColor(Node node, Graph graph) {
        Set<Node.Color> usedColors = new HashSet<>();

        for (int neighborIndex : node.neighbors) {
            Node neighbor = graph.get(neighborIndex);

            if (neighbor.color != null) {
                usedColors.add(neighbor.color);
            }
        }

        for (Node.Color color : Node.Color.values()) {
            if (usedColors.contains(color)) {
                continue;
            }

            node.color = color;
            return;
        }
    }
}
