import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class IntegerArrayWriter {
    BufferedWriter br;
    Random random = new Random(1);

    public IntegerArrayWriter(String fileName) {
        try {
            br = new BufferedWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // writes a random integer array of n elements to a file and returns the array
    int[] writeIntegerArray(int n) {
        int[] a = new int[n];
        try {
            br.write(n + "\n"); br.flush();

            for (int i = 0; i < a.length; i++) {
                a[i] = random.nextInt(n - 2) + 2;
                br.write(a[i] + " ");
            }
            br.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void main(String[] args) {
        int n;  //size of array to create (uninitialized)

        try {
            //if (args[0] != null)
            n = Integer.parseInt(args[0]);
            System.out.printf("generating an array of %d integers...\n", n);
        } catch (ArrayIndexOutOfBoundsException e) {
            //e.printStackTrace(); System.out.println("n is " + n);
            n = 20000;
            System.out.printf("generating an array of %d integers...\n", n);
        }

        String fileName = "data" + n + ".txt";
        System.out.println(fileName);

        IntegerArrayWriter writer = new IntegerArrayWriter(fileName);

        int[] a = writer.writeIntegerArray(n);

        writer.print(a);

        //System.err.println( "\n\n" + Arrays.toString(a) )
    }
}
