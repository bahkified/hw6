import java.util.NoSuchElementException;

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
 *             // http://cs.lmu.edu/~ray/notes/queues/
 *
 */

public class QueueBFS {

    private NodeBFS head = null;
    private NodeBFS tail = null;


    private class NodeBFS {
        public Object data;
        public NodeBFS next;
        public NodeBFS(Object data, NodeBFS next) {
            this.data = data;
            this.next = next;
        }
    }

    public void enqueue(Object item) {
        NodeBFS newNode = new NodeBFS(item, null);
        if (isEmpty()) {head = newNode;} else {tail.next = newNode;}
        tail = newNode;
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object item = head.data;
        if (tail == head) {
            tail = null;
        }
        head = head.next;
        return item;
    }

    public Object peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        for (NodeBFS node = head; node != null; node = node.next) {
            count++;
        }
        return count;
    }

}
