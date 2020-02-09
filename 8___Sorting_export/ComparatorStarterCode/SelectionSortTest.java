public class SelectionSortTest {
   public static void main(String[] args) {
      // input file containing the integers to sort
      In in = new In("10ints.txt");
      // the first line of input is the number of integers to sort
      Integer[] ints = new Integer[in.readInt()];

      // create an Integer array from the integers stored in input file
      for (int i = 0; i < ints.length; i++) {
         ints[i] = in.readInt();
      }

      // use selection-sort to sort the integers
      Selection.sort(ints);

      // show the sorted integers
      Selection.show(ints);

   }
}
