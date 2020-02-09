import java.util.*;

public class TestMovies {

   List<MovieInfo> movieList = new ArrayList<>();

   public static void main(String[] args) {
      new TestMovies().go();
   }

   public void go() {
      populateList();
      System.out.println(movieList); //output as read from file
      Collections.sort(movieList);
      System.out.println(movieList); //output as sorted by title

      GenreSort gs = new GenreSort();
      Collections.sort(movieList, gs);
      System.out.println(movieList); //output as sorted by genre
   }

   public void populateList() {
      // read the file, create MovieInfo instances, and
      // populate the ArrayList movieList with these instances
      In in = new In("movieInfo.txt");
      String line;
      String[] tokens;
      while (in.hasNextLine()) {
         line = in.readLine();
         tokens = line.split("/");
         movieList.add(new MovieInfo(tokens[0], tokens[1], tokens[2]));
      }
   }

}
