public class DoublyLinkedList<E> {

    public Node<E> firstNode = null; // reference to the firstNode node in this list
    public Node<E> lastNode = null;  // reference to the lastNode node in this list
    private int size = 0;         // size of this list

    // Node --- a building block of this list
    private static class Node<E> {
        E data;           // data item of generic type
        Node<E> next;     // link to the next node
        Node<E> previous; // link to the previous node

        Node(E item) {
            data = item;
        }
    }

    // insert item at front of list (takes constant time)
    public void insertAtFront(E item) {
        Node<E> newNode = new Node<E>(item);  // node to insert
        // YOUR CODE HERE
        // (You can either uncomment/modify the following 6 lines or delete them and write your own.)
        if (isEmpty()) firstNode = lastNode = newNode;
        else {
            newNode.next = firstNode;
            firstNode.previous = newNode;
            firstNode = newNode;
        }
        size++;
    }

    // insert item at end of list (takes constant time)
    public void insertAtBack(E item) {
        Node<E> newNode = new Node<E>(item);  // node to insert
        // YOUR CODE HERE
        // (You can either uncomment/modify the following 6 lines or delete them and write your own.)
        if (isEmpty()) firstNode = lastNode = newNode;
        else {
           lastNode.next = newNode;
           newNode.previous = lastNode;
           lastNode = newNode;
        }
        size++;
    }


    // remove firstNode node from list (takes constant time)
    public E removeFromFront() {
        if (isEmpty()) {
            System.out.println("can't remove from an empty list");
            return null;
        }

        E removedItem = firstNode.data;
        // YOUR CODE HERE
        // (You can either uncomment/modify the following 2 lines or delete them and write your own.)
        if (firstNode == lastNode) firstNode = lastNode = null;
        else {
            firstNode = firstNode.next;
            firstNode.previous = null;
        }
        size--;
        return removedItem;
    }

    // remove lastNode node from list (takes constant time)
    public E removeFromBack() {
        if ( isEmpty() ) { System.out.println("can't remove from an empty list"); return null; }

        E removedItem = lastNode.data;
        // YOUR CODE HERE
        // (You can either uncomment/modify the following 5 lines or delete them and write your own.)
        if (firstNode == lastNode) firstNode = lastNode = null;
        else {
            lastNode = lastNode.previous;
            lastNode.next = null;
        }
        size--;
        return removedItem;
    }

    // is this list empty? return true if yes, false otherwise.
    public boolean isEmpty() {
        return firstNode == null;
    }

    // return the size of this list
    public int size() {
        return size;
    }

    // print the data items currently in the list
    public void printForward() {
        if ( isEmpty() ) System.out.println("this list is empty");
        Node current = firstNode;
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.next;
        }
        System.out.print("\n");
    }

    public void printBackward() {
        if ( isEmpty() ) System.out.println("this list is empty");
        Node current = lastNode;
        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.previous;
        }
        System.out.print("\n");
    }


    // Unit tests for DoublyLinkedList class
    public static void main(String[] args) {
        // lines 112 to 141 test only the Node class.
        // Create a few nodes. The nodes contain Integer objects but could contain objects of other types.
        Node<Integer> two = new Node<>(2);
        Node<Integer> one = new Node<>(1);
        Node<Integer> six = new Node<>(6);
        Node<Integer> eight = new Node<>(8);

        System.out.printf(two.data + " ");
        two.next = one;
        System.out.printf (two.next.data + "\n");

        one.previous = two; one.next = six;
        six.previous = one; six.next = eight;
        eight.previous = six;

        // print list from firstNode to lastNode -- prints 2 1 6 8
        System.out.println("Printing all nodes starting with the first node and ending with the last node:");
        Node<Integer> current = two;
        while (current != null) {
            System.out.printf(current.data + " ");
            current = current.next;
        }
        System.out.println();

        // print list from lastNode to firstNode -- prints 8 6 1 2
        System.out.println("Printing all nodes starting with the last node and ending with the first node:");
        current = eight;
        while (current != null) {
            System.out.printf(current.data + " ");
            current = current.previous;
        }
        System.out.println("\n");

        // Create a doubly-linked list and test the insertAt***() methods.
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertAtBack(6);
        list.insertAtFront(1);
        list.insertAtBack(8);
        list.insertAtFront(2);

        System.out.printf("Printing list forward:  "); list.printForward();  // prints 2 1 6 8
        System.out.printf("Printing list backward: "); list.printBackward(); // prints 8 6 1 2

        // Test the removeFrom***() methods.
        System.out.printf( "\nRemoving front item: " + list.removeFromFront() + "\n");
        System.out.printf("The list is now:  "); list.printForward();
        System.out.printf( "\nRemoving back item: " + list.removeFromBack() + "\n");
        System.out.printf("The list is now:  "); list.printForward();
        System.out.printf( "\nRemoving front item: " + list.removeFromFront() + "\n");
        System.out.printf("The list is now:  "); list.printForward();
        System.out.printf( "\nRemoving back item: " + list.removeFromBack() + "\n");
        System.out.printf("The list is now:  "); list.printForward();

        // the list is now empty. try to remove an item from an empty list:
        list.removeFromBack();  // should print "can't remove from an empty list"
        list.removeFromFront(); // should print "can't remove from an empty list"

        // add your own tests
        list.insertAtFront(777);
        System.out.printf("Printing list forward:  "); list.printForward();
        // etc. etc.

    }
}
