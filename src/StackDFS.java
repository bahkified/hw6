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
 *             // http://cs.lmu.edu/~ray/notes/stacks/
 *
 */


class StackDFS  {

    private class NodeDFS {
        public Object data;
        public NodeDFS next;
        public NodeDFS(Object data, NodeDFS next) {
            this.data = data;
            this.next = next;
        }
    }

    private NodeDFS top = null;

    public void push(Object item) {
        top = new NodeDFS(item, top);
    }

    public Object pop() {
        Object item = peek();
        top = top.next;
        return item;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Object peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.data;
    }

    public int size() {
        int count = 0;
        for (NodeDFS node = top; node != null; node = node.next) {
            count++;
        }
        return count;
    }

}