package bahk.attempt;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataParser {
    public static final String dataFile = "data.txt";

    public static Graph parse() throws Exception {
        URL dataUrl = DataParser.class.getResource(dataFile);
        if (dataUrl == null) {
            System.err.println("Couldn't find data file.");
            return null;
        }

        Graph graph = new Graph();


        List<String> allLines = Files.readAllLines(Paths.get(dataUrl.toURI()));

        graph.addNodes(allLines.stream()
                        .map(line -> new Node(line.split("\\s+")[1], Integer.parseInt(line.split("\\s+")[0])))
                        .collect(Collectors.toList())
                        .toArray(new Node[allLines.size()])
        );

        allLines.stream()
                .map(line -> line.split("\\s+"))
                .forEach(arr -> IntStream.range(2, arr.length)
                                            .forEach(i -> graph.addEdge(
                                                    Integer.parseInt(arr[0]), Integer.parseInt(arr[i])
                                            )));

        return graph;
    }
}
