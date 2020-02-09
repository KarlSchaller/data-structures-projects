import java.util.HashSet;
import java.util.Set;

class SetDemo {

   public static void main(String[] args) {

      // We'll make sets out of the following items
      String[] listA = {"Ann", "Sally", "Jill", "Sally"};
      String[] listB = {"Bob", "Bill", "Ann", "Jill"};

      // Create the sets; load the sets from arrays ListA and ListB.
      // YOUR CODE HERE
      Set<String> setA = new HashSet();
      for (String s: listA)
         setA.add(s);
      Set<String> setB = new HashSet();
      for (String s: listB)
         setB.add(s);

      // Print the sets
      // YOUR CODE HERE
      System.out.println("The elements of set A are: " + setA);
      System.out.println("The elements of set B are: " + setB);

      // Find the union of the sets
      // YOUR CODE HERE
      Set<String> union = new HashSet<>(setA);
      union.addAll(setB);
      System.out.println("The union of the sets are: " + union);

      // Find the intersection of the sets
      // YOUR CODE HERE
      Set<String> intersection = new HashSet<>(setA);
      intersection.retainAll(setB);
      System.out.println("The intersection of the sets are: " + intersection);

      // Find the difference of the sets
      // YOUR CODE HERE
      Set<String> difference = new HashSet<>(setA);
      difference.removeAll(setB);
      System.out.println("The difference of the sets are: " + difference);
   }
}
