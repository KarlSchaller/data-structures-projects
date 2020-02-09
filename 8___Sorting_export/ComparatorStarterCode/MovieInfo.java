public class MovieInfo implements Comparable<MovieInfo> {
   String title;
   String genre;
   String leadActor;
   MovieInfo(String t, String g, String a) {
      title = t; genre = g; leadActor = a;
   }
   public String toString() {
      return title + " " + genre + " " + leadActor + "\n";
   }

   @Override
   public int compareTo(MovieInfo o) {
      return title.compareTo(o.title);
   }

   public String getGenre() {
      return genre;
   }
}
