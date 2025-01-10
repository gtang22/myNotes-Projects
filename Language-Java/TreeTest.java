import java.util.HashMap;
import java.util.Map;

public class TreeTest {
    private class Node {
        private int data;
        private Node left, right;
    }

    private Node root;

    private int depth(Node current, int n, int level) { // recursive helper method
        int result = level;

        if (current == null) {
            result = -1;
        }
        else if (current.data != n) {
            if (n < current.data)
                result = depth(current.left, n, level + 1);
            else if (n > current.data)
                result = depth(current.right, n, level + 1);
        }

        return result;
    }

    public int depth(int n) {
        return depth(root, n, 0);
    }

    public int sumEltsRightChildIsLeaf(){
        return sumEltsRightChildIsLeafHelper(root);
    }

    public int sumEltsRightChildIsLeafHelper(Node current){
        int result = 0;
        if (current != null) {
            Node right = current.right;
            Node left = current.left;
            
            if (isLeaf(right)) {
                result = result + right.data;
            } else {
                result = result + sumEltsRightChildIsLeafHelper(right);
                result = result + sumEltsRightChildIsLeafHelper(left);
            }
        }

        return result; 
    }

    public boolean isLeaf(Node current) {
        boolean result = false;
        if (current != null && current.right == null && current.left == null) {
            result = true;
        }
        return result;
    }

    public static Bag bagUnion(Bag bag1, Bag bag2) {
        Bag result = null;

        if (bag1 != null && bag2 != null) {
            for (Integer i : bag1.elts.keySet()) {
                result.elts.put(i, bag1.get(i));
            }

            for (Integer j : bag2.elts.keySet()) {
                    int total = result.elt.getOrDefault(j, 0) + bag2.elts.get(j);
                    result.elts.put(j, total);
            }
        }

        return result;
    }

    public Map<U, T> invert(Map<T, U> aMap) {
        Map<U, T> newMap = null;
        
        if (aMap != null) {
            newMap = new HashMap<>();
            
            for (Map.Entry<T, U> e: aMap.entrySet()) {
                newMap.put(e.getValue(), e.getKey());
            }
        }

        return newMap;
    }


}
