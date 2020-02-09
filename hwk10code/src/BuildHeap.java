import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BuildHeap {
   private int[] a;          // array to be turned into a heap
   private List<Swap> swaps; // list of swapped elements while building the heap
   private PrintWriter out;  // helps print the answer (swaps) to screen.

   public static void main(String[] args) {
      new BuildHeap().solve();
   }

   // solves the problem
   public void solve() {
      readData();
      generateSwaps();
      writeResponse();
   }


   // reads the integer array a[]
   private void readData() {
      In in = new In("Problem2-BuildHeap/10Kints.txt");
      //In in = new In("10Kints.txt");
      int n = in.readInt();
      a = new int[n];
      for (int i = 0; i < n; ++i) {
         a[i] = in.readInt();
      }
   }

   // prints the answer
   private void writeResponse() {
      out = new PrintWriter(new BufferedOutputStream(System.out));
      out.println(swaps.size());
      for (Swap swap : swaps) {
         out.println(swap.index1 + " " + swap.index2);
      }

      //out.println("Sorted Heap:");
      //for (int i : a)
      //    out.print(" " + i);
      out.close();
   }

   // swaps are generated when sinking array elements (see sink())
   private void generateSwaps() {
      swaps = new ArrayList<Swap>();

      // The following naive implementation sorts the given
      // sequence and saves the resulting sequence of swaps.
      // This turns the given array into a heap, but uses
      // (in the worst case) a quadratic number of swaps.
      // TODO: replace by a more efficient implementation
      /*for (int i = 0; i < a.length; ++i) {
         for (int j = i + 1; j < a.length; ++j) {
            if (a[i] > a[j]) {
               swaps.add(new Swap(i, j));
               exch(a, i, j);
            }
         }
      }*/
      for (int i = a.length-1; i >= 0; i--)
          sink(a, i, a.length);

      // int n = a.length-1;  // the largest index in a[]
   }

   // sinks element at position k in array a[] of size n
   // keeps a record of swapped elements.
   private void sink(int[] a, int k, int n) {
       while (k*2+1 < n) {
           int j = 2 * k + 1;
           if (j+1 < n && a[j] > a[j + 1]) j++;
           if (a[j] > a[k]) break;
           exch(a, k, j);
           swaps.add(new Swap(k, j));
           k = j;
       }
   }

   // helper: exchanges elements at positions i and j in array a[]
   private void exch(int[] a, int i, int j) {
      int swap = a[i];
      a[i] = a[j];
      a[j] = swap;
   }


   // helper class: a record of the indices of the swapped elements
   static class Swap {
      int index1;
      int index2;

      public Swap(int index1, int index2) {
         this.index1 = index1;
         this.index2 = index2;
      }
   }
}