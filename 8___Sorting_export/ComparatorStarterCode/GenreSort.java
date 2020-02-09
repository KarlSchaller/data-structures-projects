import java.util.Comparator;

public class GenreSort implements Comparator<MovieInfo> {

   @Override
   public int compare(MovieInfo one, MovieInfo two) {
      return one.getGenre().compareTo(two.getGenre());
   }
}
