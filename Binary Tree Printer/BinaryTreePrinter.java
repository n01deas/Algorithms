package binaryTreePrinter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePrinter {

    private static Node<Integer> testClassOne() {
    	
    	/*
    	 * Erstellen von Nodes 
    	 */
    	
        Node<Integer> root = new Node<Integer>(2);
        
        Node<Integer> node11 = new Node<Integer>(7);
        Node<Integer> node12 = new Node<Integer>(5);
        
        Node<Integer> node21 = new Node<Integer>(2);
        Node<Integer> node22 = new Node<Integer>(6);
        Node<Integer> node23 = new Node<Integer>(3);
        Node<Integer> node24 = new Node<Integer>(6);
        
        Node<Integer> node31 = new Node<Integer>(5);
        Node<Integer> node32 = new Node<Integer>(8);
        Node<Integer> node33 = new Node<Integer>(4);
        Node<Integer> node34 = new Node<Integer>(5);
        Node<Integer> node35 = new Node<Integer>(8);
        Node<Integer> node36 = new Node<Integer>(4);
        Node<Integer> node37 = new Node<Integer>(5);
        Node<Integer> node38 = new Node<Integer>(8);

        /*
         * Zuweisen der Nodes ihrer Verzweigungen 
         */
        
        root.links = node11;
        root.rechts = node12;

        node11.links = node21;
        node11.rechts = node22;
        node12.links = node23;
        node12.rechts = node24;

        node21.links = node31;
        node21.rechts = node32;
        node22.links = node33;
        node22.rechts = node34;
        node23.links = node35;
        node23.rechts = node36;
        node24.links = node37;
        node24.rechts = node38;

        return root;
    }

    private static Node<Integer> testClassTwo() {
    	
    	/*
    	 * Erstellen von Nodes 
    	 */

    	
        Node<Integer> root = new Node<Integer>(2);
        
        Node<Integer> node11 = new Node<Integer>(7);
        Node<Integer> node12 = new Node<Integer>(5);
        
        Node<Integer> node21 = new Node<Integer>(2);
        Node<Integer> node22 = new Node<Integer>(6);
        Node<Integer> node23 = new Node<Integer>(9);
        
        Node<Integer> node31 = new Node<Integer>(5);
        Node<Integer> node32 = new Node<Integer>(8);
        Node<Integer> node33 = new Node<Integer>(4);

        /*
         * Zuweisen der Nodes ihrer Verzweigungen 
         */
        
        root.links = node11;
        root.rechts = node12;

        node11.links = node21;
        node11.rechts = node22;

        node12.rechts = node23;
        node22.links = node31;
        node22.rechts = node32;

        node23.links = node33;

        return root;
    }
    
    public static Node<Integer> testClassThree(){
    	
    	/*
    	 * Erstellen von Nodes 
    	 */
    	
    	Node<Integer> root = new Node<Integer>(54);
    	
    	Node<Integer> node11 = new Node<Integer>(32);
    	Node<Integer> node12 = new Node<Integer>(345);

    	Node<Integer> node21 = new Node<Integer>(1);
    	Node<Integer> node22 = new Node<Integer>(3);

    	/*
         * Zuweisen der Nodes ihrer Verzweigungen 
         */
    	
    	root.links = node11;
    	root.rechts = node12;
    	
    	node11.links = node21;
    	node11.links = node22;
    	
    	node22.links = node21;
    	
    	
    	return root;
    }

    public static void main(String[] args) {
    	
    	/*
    	 * Ausgeben des Binärbaums / der Binärbäume auf der Konsole
    	 */

        BTreePrinter.printNode(testClassOne());
        BTreePrinter.printNode(testClassTwo());
        BTreePrinter.printNode(testClassThree());

    }
}

class Node<T extends Comparable<?>> {
    Node<T> links, rechts;
    T data;

    public Node(T data) {
        this.data = data;
    }
}

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.alleElementeNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.setzeLeerzeile(firstSpaces);

        List<Node<T>> neueNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                neueNodes.add(node.links);
                neueNodes.add(node.rechts);
            } else {
            	neueNodes.add(null);
            	neueNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.setzeLeerzeile(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.setzeLeerzeile(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.setzeLeerzeile(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).links != null)
                    System.out.print("/");
                else
                    BTreePrinter.setzeLeerzeile(1);

                BTreePrinter.setzeLeerzeile(i + i - 1);

                if (nodes.get(j).rechts != null)
                    System.out.print("\\");
                else
                    BTreePrinter.setzeLeerzeile(1);

                BTreePrinter.setzeLeerzeile(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(neueNodes, level + 1, maxLevel);
    }

    private static void setzeLeerzeile(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.links), BTreePrinter.maxLevel(node.rechts)) + 1;
    }

    private static <T> boolean alleElementeNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}
