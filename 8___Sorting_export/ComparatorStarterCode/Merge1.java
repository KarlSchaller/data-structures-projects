/******************************************************************************
 *  Compilation:  javac Merge1.java
 *  Execution:    java Merge1 < input.txt
 *  Dependencies: In.java
 *  Data files:   10ints.txt
 *
 *  Sorts a sequence of integers from standard input using mergesort.
 *
 *  % more 10ints.txt
 *  10                        [first  line: how many integers to sort]
 *  4 1 3 2 16 9 10 14 8 7    [second line: the integers to sort ]
 *
 ******************************************************************************/

//  The Merge1 class provides static methods for sorting an array of integers
//  using mergesort. See Merge2 for a class that sorts an array of comparable
//  objects.
public class Merge1 {

   // This class should not be instantiated.
   private Merge1() { }

   // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
   private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {

      // WE'LL IMPLEMENT THIS METHOD IN CLASS
   }

   // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
   private static void sort(int[] a, int[] aux, int lo, int hi) {

      // WE'LL IMPLEMENT THIS METHOD IN CLASS
   }

   // Rearranges the array in ascending order, using the natural order.
   public static void sort(int[] a) {
      int[] aux = new int[a.length];
      sort(a, aux, 0, a.length-1);
   }


   // print array to standard output
   private static void show(int[] a) {
      for (int i = 0; i < a.length; i++) {
         System.out.println(a[i]);
      }
   }

   // Reads in a sequence of strings from standard input; mergesorts them;
   // and prints them to standard output in ascending order.
   public static void main(String[] args) {
      //In in = new In("tiny.txt");
      In in = new In("10ints.txt");
      int n = in.readInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
         a[i] = in.readInt();
      }
      Merge1.sort(a); // the output will be correct after we implement
      show(a);        // the methods sort() & merge() above.
   }
}

