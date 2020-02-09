import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TopMints {
   public static void main(String[] args) throws FileNotFoundException {
      FastScanner sc = new FastScanner(new FileInputStream("1Mints.txt"));
      // FastScanner sc = new FastScanner(new FileInputStream("10ints.txt"));
      int m = 5; // keep only top m integers
      int n = sc.nextInt();       // the first input integer is the number of input lines that follow
      // n = 50;
      Integer[] a = new Integer[n];

      MinPQ<Integer> pq = new MinPQ<>(m);
      Stopwatch timer1 = new Stopwatch();
      for (int i = 0; i < n; i++) {
         a[i] = sc.nextInt();
         pq.insert(a[i]);
         // YOUR CODE HERE (1 or 2 lines: a single if statement should do the job)
         // remove minimum if m+1 entries on the PQ
         if (pq.size()>m+1)
            pq.delMin();
      }

      double time1 = timer1.elapsedTime();
      System.out.printf("It took (%.2f seconds) to output these \n" +
            "top 5 integers using a priority queue.\n",  time1);

      // see what ended up in the priority queue
      for (Integer integer : pq) {
         System.out.println(integer);
      }



      // Test the time it takes to find m largest using sorting
      Stopwatch timer2 = new Stopwatch();
      /*for (int i = 0; i < n; i++) {
         a[i] = sc.nextInt();
      }*/
      System.out.println("------");
      System.out.println("------");
      Arrays.sort(a);
      for (int i = n-m; i < n; i++) {
         System.out.println(a[i]);
      }

      double time2 = timer2.elapsedTime();
      System.out.printf("It took (%.2f seconds) to output these \n" + "" +
            "top 5 integers when I sorted the integers.\n",  time2);

   }

   // Helper inner static class. NO NEED TO EDIT IT.
   // Class FastScanner helps read input into your program.
   static class FastScanner {
      BufferedReader br;
      StringTokenizer st;

      FastScanner(InputStream stream) {
         try {
            br = new BufferedReader(new
                  InputStreamReader(stream));
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

      String next() {
         while (st == null || !st.hasMoreTokens()) {
            try {
               st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         return st.nextToken();
      }

      int nextInt() {
         return Integer.parseInt(next());
      }
   }
}
