/******************************************************************************
 *  Compilation:  javac Merge2.java
 *  Execution:    java Merge2 < input.txt
 *  Dependencies: In.java
 *  Data files:   tiny.txt
 *                words3.txt
 *
 *  Sorts a sequence of strings from standard input using mergesort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Merge2 < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Merge2 < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 ******************************************************************************/

//  The Merge2 class provides static methods for sorting an
//  array using mergesort.
public class Merge2 {

   // This class should not be instantiated.
   private Merge2() { }

   // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
   private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

      // copy to aux[]
      for (int k = lo; k <= hi; k++) {
         aux[k] = a[k];
      }

      // merge back to a[]
      int i = lo, j = mid+1;
      for (int k = lo; k <= hi; k++) {
         if      (i > mid)              a[k] = aux[j++];
         else if (j > hi)               a[k] = aux[i++];
         else if (less(aux[j], aux[i])) a[k] = aux[j++];
         else                           a[k] = aux[i++];
      }
   }

   // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
   private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
      if (hi <= lo) return;
      int mid = lo + (hi - lo) / 2;
      sort(a, aux, lo, mid);
      sort(a, aux, mid + 1, hi);
      merge(a, aux, lo, mid, hi);
   }

   // Rearranges the array in ascending order, using the natural order.
   public static void sort(Comparable[] a) {
      Comparable[] aux = new Comparable[a.length];
      sort(a, aux, 0, a.length-1);
   }


   /***************************************************************************
    *  Helper sorting function.
    ***************************************************************************/

   // is v < w ?
   private static boolean less(Comparable v, Comparable w) {
      return v.compareTo(w) < 0;
   }


   // print array to standard output
   private static void show(Comparable[] a) {
      for (int i = 0; i < a.length; i++) {
         System.out.println(a[i]);
      }
   }

   // Reads in a sequence of strings from a file; mergesorts them;
   // and prints them to standard output in ascending order.
   public static void main(String[] args) {
      //In in = new In("tiny.txt");
      In in = new In("words3.txt");
      String[] a = in.readAllStrings();
      Merge2.sort(a);
      show(a);
   }
}