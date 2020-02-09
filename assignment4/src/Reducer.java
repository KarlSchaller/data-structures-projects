import java.util.HashMap;

public class Reducer {

   public HashMap<String, Integer> reduce(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
      // YOUR CODE HERE
      HashMap<String, Integer> reduced = new HashMap<>(map1);
      for (String word: map2.keySet()) {
         if (map1.containsKey(word))
            reduced.put(word, map1.get(word) + map2.get(word));
         else
             reduced.put(word, map2.get(word));
      }

      return reduced;
   }

   public static void main(String[] args) {

      Mapper mapper1 = new Mapper("tiny1.txt");
      HashMap<String, Integer> map1 = mapper1.getWordcount();
      System.out.println(map1);

      Mapper mapper2 = new Mapper("tiny2.txt");
      HashMap<String, Integer> map2 = mapper2.getWordcount();
      System.out.println(map2);

      HashMap<String, Integer> map = new Reducer().reduce(map1, map2);
      System.out.println(map);
      // System.out.println(new Mapper("tinyTale.txt").getWordcount());
   }
}
