/******************************************************************************
 *  Stater code for homework assignment 2
 *  Compilation:  javac Leader.java
 *  Execution:    java Leader 7 3
 *
 *  % java Leader 7 3
 *  3
 *  6
 *  2
 *  7
 *  5
 *  1
 *  leader:  4
 ******************************************************************************/
public class Leader {
    public static void main(String[] args) {
        //int n = Integer.parseInt(args[0]); // n: total number of people
        //int m = Integer.parseInt(args[1]); // m-th person is eliminated at each round
        int n = 100;
        int m = 7;

        // YOUR SOLUTION GOES HERE (Note: if you use a suitable data structure,
        // you can write a solution in under 10 lines of code.)
        SLList<Integer> list = new SLList<Integer>();
        for (int i = 1; i <= n; i++)
            list.insertAtBack(i);
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++)
                list.insertAtBack(list.removeFromFront());
            System.out.println(list.removeFromFront());
        }
        System.out.println("leader: "+list.removeFromFront());
    }

    // Code copied from SLList.java
    static class Node<E> {
        E data;
        Node<E> next;

        // constructors...
        Node (E item) { this(item, null); }
        Node (E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    public static class SLList<E> {
        private Node<E> firstNode;
        private Node<E> lastNode;

        // insert item at front of list (takes constant time)
        public void insertAtFront(E item) {
            if (isEmpty())
                firstNode = lastNode = new Node<E>(item);
            else
                firstNode = new Node<E>(item, firstNode);
        }

        // insert item at end of list (takes constant time)
        public void insertAtBack(E item) {
            if (isEmpty())
                firstNode = lastNode = new Node<E>(item);
            else
                lastNode = lastNode.next = new Node<E>(item);
        }

        // remove first node from list (takes constant time)
        public E removeFromFront() {
            if (isEmpty()) throw new RuntimeException();

            E removedItem = firstNode.data;
            if (firstNode == lastNode) firstNode = lastNode = null;
            else firstNode = firstNode.next;
            return removedItem;
        }

        // remove last node from list (takes time proportional to the size of the list)
        public E removeFromBack() {
            if (isEmpty()) throw new RuntimeException();

            E removedItem = lastNode.data;
            if (firstNode == lastNode) firstNode = lastNode = null;
            else {
                Node<E> current = firstNode;
                while (current.next != lastNode) // this loops until current refers to the second to last node
                    current = current.next;
                current.next = null;
                lastNode = current;
            }
            return removedItem;
        }

        // is this list empty? return true if yes, false otherwise.
        public boolean isEmpty() {
            return firstNode == null;
        }

        // print the data items currently in the list
        public void print() {
            if ( isEmpty() ) System.out.println("this list is empty");
            Node current = firstNode;
            while (current != null) {
                System.out.printf("%s ", current.data);
                current = current.next;
            }
            System.out.print("\n\n");
        }
    }
}