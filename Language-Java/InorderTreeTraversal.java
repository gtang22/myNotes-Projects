import java.util.*;
public class InorderTreeTraversal {
    public static class Node {
        int value;
        Node right;
        Node left;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;

        }
    }
    
    private Node root = null;

    public int numEltsLessThan(int n) {
        Node current = root;
        Stack<Node> s = new Stack<>();
        int count = 0;
        
        while (current != null || s.size() > 0) {
            while (current != null) {
                s.push(current);
                current = current.left;
            }

            current = s.pop();
            // process code
            if (current.value < n) {
                count++;
            } 
            else {
                break;
            }

            current = current.right;
        }

        return count;

    }

    public static void main(String args[]) {
        InorderTreeTraversal tree = new InorderTreeTraversal();
        InorderTreeTraversal.Node node1 = new InorderTreeTraversal.Node(10, null, null);
        InorderTreeTraversal.Node node2 = new InorderTreeTraversal.Node(8, null, node1);
        InorderTreeTraversal.Node node3 = new InorderTreeTraversal.Node(18, null, null);
        InorderTreeTraversal.Node node4 = new InorderTreeTraversal.Node(14, node2, node3);
        InorderTreeTraversal.Node node5 = new InorderTreeTraversal.Node(24, null, null);
        InorderTreeTraversal.Node node6 = new InorderTreeTraversal.Node(22, null, node5);
        InorderTreeTraversal.Node node7 = new InorderTreeTraversal.Node(25, node6, null);
        InorderTreeTraversal.Node node8 = new InorderTreeTraversal.Node(36, null, null);
        InorderTreeTraversal.Node node9 = new InorderTreeTraversal.Node(50, null, null);
        InorderTreeTraversal.Node node10 = new InorderTreeTraversal.Node(40, node8, node9);
        InorderTreeTraversal.Node node11 = new InorderTreeTraversal.Node(32, null, node10);
        InorderTreeTraversal.Node node12 = new InorderTreeTraversal.Node(30, node7, node11);
        tree.root = new InorderTreeTraversal.Node(20, node4, node12);

        System.out.println(tree.numEltsLessThan(100));
    }
}