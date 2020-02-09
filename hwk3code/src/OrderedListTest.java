import java.util.Random;
public class OrderedListTest {
    /** Traverses ordered list and displays each element.
     *  Displays an error message if an element is out of order.
     */
    public static void traverseAndShow(OrderedList<Integer> testList) {
        int prevItem = testList.get(0);
        // Traverse ordered list and display any value that
        // is out of order.
        for (Integer thisItem : testList) { System.out.println(thisItem); if (prevItem > thisItem)
            System.out.println("*** FAILED, value is " + thisItem);
            prevItem = thisItem;
        }
    }
    public static void main(String[] args) {
        OrderedList<Integer> testList = new OrderedList<>();
//        final int MAX_INT = 500;
//        final int START_SIZE = 100;
        final int MAX_INT = 20;
        final int START_SIZE = 5;
        // Create a random number generator.
        Random random = new Random(2168);
        // Fill list with START_SIZE random values.
        for (int i = 0; i < START_SIZE; i++) {
            int r = random.nextInt(MAX_INT); // generate a random integer r, where 0 <= r < MAX_INT
            testList.add(r);
        }

        // first, print the list before running the textbook tests
        System.out.println("The original list:");
        for (Integer k : testList) {
            System.out.print(k + " ");
        }
        System.out.println();



//        // Add to beginning and end of list.
        System.out.println("\nRunning tests from page 102 of the textbook:");
        testList.add(-1);
        testList.add(MAX_INT + 1);
        traverseAndShow(testList); // Traverse and display.
        // Remove first, last, and middle elements.
        Integer first = testList.get(0);
        Integer last = testList.get(testList.size() - 1);
        Integer middle = testList.get(testList.size() / 2);
        testList.remove(first);
        testList.remove(last);
        testList.remove(middle);
        traverseAndShow(testList); // Traverse and display.
    }
}
