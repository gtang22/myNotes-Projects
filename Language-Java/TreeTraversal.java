import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {
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

    public void inorder() {
        Stack<Node> s = new Stack<>();
        Node current = root; 

        while (current != null || s.size() > 0) {
            while (current != null) {
                s.push(current);
                current = current.left;
            }

            current = s.pop();

            // data processed
            System.out.println(current.value);

            current = current.right;
        }
    }

    public void preorder() {
        Stack<Node> s = new Stack<>();
        Node current = root;

        s.push(current);

        while (s.size() > 0) {
            current = s.pop();

            // process data
            System.out.println(current.value);

            if (current.right != null){
                s.push(current.right);
            }

            if (current.left != null){
                s.push(current.left);
            }
        }
    }

    public void postorder() {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Node current = root;

        s1.push(current);

        while (s1.size() > 0) {
            current = s1.pop();
            s2.push(current);

            if (current.left != null) {
                s1.push(current.left);
            }
            if (current.right != null) {
                s1.push(current.right);
            }
        }

        while (s2.size() > 0) {
            current = s2.pop();
            // process data
            System.out.println(current.value);
        }
    }

    public void postorderTwo() {
        Stack<Node> s = new Stack<>();
        List<Node> l = new ArrayList<>();
        Node current = root;

        s.push(current);
        while (s.size() > 0) {
            current = s.pop();
            l.add(current);

            if (current.left != null) {
                s.push(current.left);
            }

            if (current.right != null) {
                s.push(current.right);
            }
        }

        for (int i = l.size() - 1; i >= 0; i--) {
            //data process
            System.out.println(l.get(i).value);
        }
    }
    
    public void bfs() {
        Queue<Node> q = new LinkedList<>();
        Node current = root;

        q.add(current);

        while (q.size() > 0) {
            current = q.poll();
            // data processed
            System.out.println (current.value);

            if (current.left != null) {
                q.add(current.left);
            }

            if (current.right != null) {
                q.add(current.right);
            }
        }
    }

    public void bfsLevel() {
        Queue<Node> q = new LinkedList<>();
        Node current = root;
        int level = 0;

        q.add(current);

        while (q.size() > 0) {
            int size = q.size();

            for (int i = 0; i < size; i ++) {
                current = q.poll();
                // data processed
                System.out.println (current.value);
                
                if (current.left != null) {
                    q.add(current.left);
                }
    
                if (current.right != null) {
                    q.add(current.right);
                }
            }

            level ++;
        }
    }

    // Recursive 

    public void preOrderRecursiveHelper(Node n) {
        if (n != null) {
            System.out.println(n.value);
            preOrderRecursiveHelper(n.left);
            preOrderRecursiveHelper(n.right);
        }

    }

    public void inOrderRecursiveHelper(Node n) {
        if (n != null) {
            inOrderRecursiveHelper(n.left);
            System.out.println(n.value);
            inOrderRecursiveHelper(n.right);
        }
    }

    public void postOrderRecursive(Node n) {
        if (n != null) {
            postOrderRecursive(n.left);
            postOrderRecursive(n.right);
            System.out.println(n.value);
        }
    }
}
