/******************************************************************************
 *  Compilation:  javac Stack.java
 *  Execution:    java Stack
 *
 *  A generic stack, implemented using a singly linked list.
 *  Each stack element is of type E.
 *
 *  In this demo, the test in main() reads in a String array (instead of reading
 *  a file from standard input) and pushes each element of the array onto the
 *  stack. It then prints the stack from top to bottom.
 *
 ******************************************************************************/

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

// EXERCISE 1: CHANGE THE CLASS DEFINITION SO THAT THE STACK IS ITERABLE
public class Stack<E> implements Iterable<E> {
    private Node<E> first;     // top of stack
    private int size;          // size of the stack

    // helper Node class
    private static class Node<E> {
        private E item;
        private Node<E> next;
    }

    // Initializes an empty stack.
    public Stack() {
        first = null;
        size = 0;
    }

     //Returns true if this stack is empty.
    public boolean isEmpty() {
        return first == null;
    }


    // Returns the number of items in this stack.
    public int size() {
        return size;
    }


    // Adds the item to this stack.
    public void push(E item) {
        Node<E> oldfirst = first;
        first = new Node<E>();
        first.item = item;
        first.next = oldfirst;
        size++;
    }


    // Removes and returns the item most recently added to this stack.
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        E item = first.item;        // save item to return
        first = first.next;            // delete first node
        size--;
        return item;                   // return the saved item
    }



    // EXERCISE 2:
    // Returns an iterator to this stack that iterates through the items in LIFO order.
    public Iterator<E> iterator() {
        return new ListIterator(first);
    }

    // EXERCISE 3:
    // an iterator, we choose to not implement remove() since it's optional
    // MAKE SURE TO IMPLEMENT next() and hasNext() methods
    private class ListIterator implements Iterator<E> {
        private Node<E> current;

        public ListIterator(Node<E> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E item = current.item;
            current = current.next;
            return item;
        }
    }

  // IF YOU COMPLETED EXERCISES 1 - 3, UNCOMMENT toString() -- IT SHOUD NOW WORK
    // Returns a string representation of this stack.
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (E item : this) {
                s.append(item);
                s.append(' ');
            }
            return s.toString();
        }

    // Unit tests the Stack data type.
    public static void main(String[] args) {
        String[] input = {"it", "was", "the", "best", "of", "times", "it", "was"};
        System.out.print("\nThe items that will be pushed into the stack bag are: ");
        System.out.println(Arrays.toString(input));

  // IF YOU COMPLETED EXERCISES 1 - 3,
  // UNCOMMENT THE FOLLOWING LINES -- YOUR PROGRAM SHOULD NOW WORK
        Stack<String> stack = new Stack();
        for (String item : input) {
            stack.push(item);
        }
        System.out.println("\nSize of stack = " + stack.size() +". Items from top to bottom are:\n");
        for (String s : stack) {
            System.out.println("\t\t\t" + s);
        }
        System.out.println();
        System.out.println(stack);
    }
}
