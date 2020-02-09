public class SinglyLinkedList<E> {
    private Node<E> firstNode;
    private Node<E> lastNode;
    private int size;

    private static class Node<E> {
        private E data;
        private Node<E> next;

        // constructors...
        Node (E item) { this(item, null); }
        Node (E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    // insert item at front of list (takes constant time)
    public void insertAtFront(E item) {
        if ( isEmpty() ) { firstNode = lastNode = new Node<E>(item); }
        else firstNode = new Node<E> (item, firstNode);
        size++;
    }

    // insert item at end of list (takes constant time)
    public void insertAtBack(E item) {
        if ( isEmpty() ) { firstNode = lastNode = new Node<E>(item); }
        else lastNode = lastNode.next = new Node<E>(item);
        size++;
    }

    // remove first node from list (takes constant time)
    public E removeFromFront() {
        if ( isEmpty() ) { System.out.println("Can't remove from front: this list is empty"); return null; }

        E removedItem = firstNode.data;
        if (firstNode == lastNode) firstNode = lastNode = null;
        else firstNode = firstNode.next;
        size--;
        return removedItem;
    }

    // remove last node from list (takes time proportional to the size of the list)
    public E removeFromBack() {
        if ( isEmpty() ) { System.out.println("Can't remove from back: this list is empty"); return null; }

        E removedItem = lastNode.data;
        if (firstNode == lastNode) firstNode = lastNode = null;
        else {
            Node<E> current = firstNode;
            // loop while current node does not refer to the last node
            while (current.next != lastNode ) {
                current = current.next;
            }
            lastNode = current; // current is now the new lastNode
            current.next = null;
        }
        size--;
        return removedItem;
    }

    // is this list empty? return true if yes, false otherwise.
    public boolean isEmpty() { return firstNode == null; }

    // return the size of this list
    public int size() { return size; }

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

