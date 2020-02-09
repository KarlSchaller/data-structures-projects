/*   Class SLList implements a singly-linked list. Node is a helper class used by SLList.

        ######## Karl Schaller ########

   Assignment: 1. Complete the implementation by filling in the code (by Wed, Sep 18)
               2. Create a separate file, DLList.java that implements a doubly-linked-list (by Fri, Sep 20)
               3. Implement a circular-list (by Fri, Sep 20)
               4. Use one of these implementations to complete homework 2, where you're asked to write a file
                  called Leader.java, which uses one of these implementations to efficiently fine the leader.

 Parts 1, 2, and 3 must be demonstrated by Friday, Sep 20. Part 4 - by Monday, Sep 23.
 */

class Node<E> {
    E data;
    Node<E> next;

    // constructors...
    Node (E item) { this(item, null); }
    Node (E dataItem, Node<E> nodeRef) {
        data = dataItem;
        next = nodeRef;
    }
}

public class SLList<E> {
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
