package tree.bstree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Preorder for serialization and recursion for deserialization.
 *
 * Serialize the following tree to: "5,3,2,6,7".
 *
 *      5
 *    /  \
 *   3    6
 *  /     \
 * 2      7
 *
 */
public class BinarySearchTreeSerialization {
    private static final String SEPARATOR = " ";
    private static final String NULL = "#";

    // Encodes a tree to a single string in reversed sequence of pre-order
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return NULL;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            root = stack.pop();
            sb.append(root.value).append(SEPARATOR);
            if (root.rightChild != null) {
                stack.push(root.rightChild);
            }
            if (root.leftChild != null) {
                stack.push(root.leftChild);
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree, pre-order traversal
    public Node deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals(NULL)) {
            return null;
        }
        String[] values = data.split(SEPARATOR);
        Queue<Integer> queue = new LinkedList<>();
        for (String val : values) {
            queue.offer(Integer.parseInt(val));
        }
        return helper(queue);
    }

    // some notes:
    //   5
    //  3 6
    // 2   7
    private Node helper(Queue<Integer> queue) { // queue: 5,3,2,6,7
        if (queue.isEmpty()) {
            return null;
        }
        Node root = new Node(queue.poll()); // root (5)
        Queue<Integer> samllerQueue = new LinkedList<>();
        while (!queue.isEmpty() && (queue.peek() < (Integer) root.value)) {
            samllerQueue.offer(queue.poll());
        }
        //smallerQueue : 3,2   storing elements smaller than 5 (root)
        root.leftChild = helper(samllerQueue);
        //queue: 6,7   storing elements bigger than 5 (root)
        root.rightChild = helper(queue);
        return root;
    }
}