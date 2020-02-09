import java.util.*;
public class TestSort {
   public static void main(String[] args) {
      List <String> stuff = new ArrayList<>();
      stuff.add("Philadelphia");
      stuff.add("New York");
      stuff.add("Hanoi");
      stuff.add("Tbilisi");
      stuff.add("Warsaw");
      System.out.println("unsorted " + stuff);
      Collections.sort(stuff);
      System.out.println("sorted   " + stuff);
   }
}
