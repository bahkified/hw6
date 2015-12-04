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
 *             : http://krishnalearnings.blogspot.in/2015/11/breadth-first-search-in-java-using.html
 *
 */

public class BFS {

    private Node[] vertices; // stores the nodes of the graph
    private int size; // number of nodes in the graph
    private QueueBFS queue;

    public BFS(int size) {
        this.size = size;
        vertices = new Node[size];
        addNodes();
        queue = new QueueBFS(size);
    }

    public class Node {
        int name;
        Neighbour neighbourList;
        State state;
        Node(int name) {
            this.name = name;
            state = State.NEW;
        }
    }

    public class Neighbour {
        int index;
        Neighbour next;

        public Neighbour(int index, Neighbour next) {
            this.index = index;
            this.next = next;
        }
    }
    private void addNodes(){
        for(int i = 1; i <= size ; i++){
            addNode(i);
        }
    }
    public void addNode(int name) {
        vertices[name - 1] = new Node(name);
    }

    public void addEdge(int sourceName, int destiName) {
        int srcIndex = sourceName - 1;
        int destiIndex = destiName - 1;
        Node srcNode = vertices[srcIndex];
        Node destiNode = vertices[destiIndex];
        srcNode.neighbourList = new Neighbour(destiIndex, srcNode.neighbourList);
        // the graph is non directional so if from S, D is reachable then vice
        // versa is also true
        destiNode.neighbourList = new Neighbour(srcIndex, destiNode.neighbourList);
    }

    public void traverseGraph() {
        System.out.println("Using BFS Traversing the graph");

        for (int i = 0; i < size; i++) {
            if (vertices[i].state != State.VISITED) {
                bfs(vertices[i]);
            }
        }
    }

    private void bfs(Node currentNode) {
        queue.add(currentNode);
        currentNode.state = State.IN_Q;
        while(!queue.isEmpty()){
            Node visitedNode = queue.remove();
            visitedNode.state = State.VISITED;
            System.out.println(visitedNode.name);
            Neighbour temp = visitedNode.neighbourList;
            while(temp != null){
                Node neighbour = vertices[temp.index];
                if(neighbour.state == State.NEW){
                    queue.add(neighbour);
                    neighbour.state = State.IN_Q;
                }
                temp = temp.next;
            }
        }
    }

    public enum State {
        NEW, IN_Q, VISITED
    };

    public class QueueBFS {
        Node[] queue;
        int maxSize;
        int front = -1,rear = -1;

        QueueBFS(int maxSize) {
            this.maxSize = maxSize;
            queue = new Node[maxSize];
        }

        public void add(Node node) {
            queue[++rear] = node;
        }

        public Node remove() {
            Node node = queue[++front];
            queue[front] = null;
            return node;
        }

        public boolean isEmpty() {
            return front == rear;
        }
    }
}
