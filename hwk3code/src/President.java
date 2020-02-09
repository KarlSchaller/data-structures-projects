/* This class should implement a Comparable interface (right now it doesn't)
   for OrderedListTest3.java to work.
   Comparable objects implement the compareTo() method. Implement this method
   based on how you'd like the objects of this class to be compared.
 */
public class President implements Comparable<President>  {  // you should change this line

    String name;
    int year;

    public President(String firstName, int yearElected) {
        name = firstName;
        year = yearElected;
    }

    public String toString() {
        return name;
    }

    // decide how you'd like the President objects compared and
    // implement this method appropriately.
    //@Override
    public int compareTo(President that) {
        // YOUR CODE GOES HERE
        return this.name.compareTo(that.name); // for alphabetical
        //return this.year - that.year; // for sort by year
    }
}
