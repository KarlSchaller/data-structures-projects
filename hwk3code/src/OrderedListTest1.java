import java.util.Random;

public class OrderedListTest1 {

    // generate 10 random integers in the range 0 - 99, put them in non-decreasing order and display
    public static void main(String[] args) {
        OrderedList<Integer> list = new OrderedList<>();

        System.out.printf("\nThe list is originally empty.\n");
        Random random = new Random(2168);
        for (int i = 0; i < 8; i++) {
            int r = random.nextInt(100); // generate a random integer r, where 0 <= r < 100
            System.out.println("Generate a new element, " + Integer.toString(r) + ", and add it to the list.");
            list.add(r); // add r in the correct place in the list
        } // The random integers should now be in order of your OrderedList's add() method is correct

        // IF YOU JUST RUN THE STARTER CODE, THE LIST IS *NOT* IN ORDER.
        System.out.println("\nThe list is now:");
        printList(list); // prints 82  68  61  66  41  76  15  31  26  4  ( NOT what you want)

        System.out.println("\nRemoving the first list item... The list is now:");
        list.remove(list.get(0));
        printList(list);

        System.out.println("\nRemoving the third-from-the-left item... The list is now:");
        list.remove(list.get(2));
        printList(list);

        System.out.println("\nRemoving the last item... The list is now:");
        list.remove(list.get(list.size() - 1));
        printList(list);
    }


    // prints the ordered list
    public static <E extends Comparable<E>> void printList(OrderedList<E> list) {
        for (E item : list) {
            System.out.print(item + "  ");
        }
        System.out.println();
    }
}
