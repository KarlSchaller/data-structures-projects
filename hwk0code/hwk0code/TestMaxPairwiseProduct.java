import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestMaxPairwiseProduct {

    MaxPairwiseProduct test = new MaxPairwiseProduct();
    //Random random = new Random(1);

    void test(int[] a, long answer, String testName) {
        Stopwatch timer = new Stopwatch();
        long result = test.getMaxPairwiseProduct(a);
        double time = timer.elapsedTime();
        System.out.printf("\n%s took %.4f seconds to complete. %n", testName, time);
            System.out.printf("The correct answer is  %,d. The tested method returned %,d.%n", answer, result);

        if ( (result == answer) && (time <= 1.2) )
            System.out.println("\033[0;32m" + testName + " passed.\033[0m");
        else
            System.out.println("\033[1;31m" + testName + " FAILED. \033[0m");
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2, 3}; int ans1 = 6;
        int[] test2 = {7, 5, 14, 2, 8, 8, 10, 1, 2, 3}; int ans2 = 140;
        int[] test3 = {100000, 90000}; long ans3 = 9000000000L;
        int[] test4 = new In("data20.txt").readIntArray(); long ans4 = 306;
        int[] test5 = new In("data2000.txt").readIntArray(); long ans5 = 3976036;
        int[] test6 = new In("data20000.txt").readIntArray(); long ans6 = 399760035L;
        int[] test7 = new In("data200000.txt").readIntArray(); long ans7 = 39999400002L;
        int[] test8 = new int[200000]; long ans8 = 39999800000L;
        for (int i = 0; i < test8.length; i++)
            test8[i] = i + 1;


        TestMaxPairwiseProduct t = new TestMaxPairwiseProduct();
        t.test(test1, ans1, "Test 1");
        t.test(test2, ans2, "Test 2");
        t.test(test3, ans3, "Test 3");
        t.test(test4, ans4, "Test 4");
        t.test(test5, ans5, "Test 5");
        t.test(test6, ans6, "Test 6");
        t.test(test7, ans7, "Test 7");
        t.test(test8, ans8, "Test 8");

    }
}

// A helper class. Reads an integer array that is stored in a file.
class In {
    private Scanner scanner;

    // Constructor. This instance of In will read data from the standard input.
    public In() {
        scanner = new Scanner(new BufferedInputStream(System.in));
    }
    // Constructor. This instance of In will read data from a file.
    public In(String name) {
        try {
            File file = new File(name);
            scanner = new Scanner(new BufferedReader(new FileReader(file)));
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("\n\033[1;31m FILE NOT FOUND. Please provide a valid filename.\n \033[m");
        } catch (NullPointerException ne) {
            System.out.println("\n\033[1;31m Please provide a valid filename. \n \033[m");
        }
    }
    /* read the next integer from an input stream */

    int nextInt() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("attempts to read an 'int' value from the input stream, "
                    + "but the next token is not an integer");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'int' value from the input stream, "
                    + "but no more tokens are available");
        }
    }
    /* read integers from an input stream, store them in an array and return the array */

    int[] readIntArray() {
        int n = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        close();
        return a;
    }

    /* prints array to the standard output */
    void print(int[] a) {
        int n = a.length;
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.println();
    }
    /* close this input stream */

    void close() {
        scanner.close();
    }

    // a test client for class In
    public static void main(String[] args) {

        // test 1: data is stored in a file
//        In in = new In("data20000.txt");
//
//        int[] a = in.readIntArray();
//        in.print(a);
//
//        // test 2: input data from console
        In in = new In();
        int[] a = in.readIntArray();
        in.print(a);

    }
}
