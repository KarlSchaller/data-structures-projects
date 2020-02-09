import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Pattern;


public class MapDemo {

    // Tree that stores the index
    private final TreeSet<String> index;

    // Constructor
    public MapDemo() { index = new TreeSet<>(); }

    // Reads each word in the input file and store it
    // in an index along with its line number.
    public void buildTree(Scanner scanner) {
        int lineNum = 0;  // line number
        StringTokenizer st;
        String token;

    }

    // Perform an inorder traversal of the tree
    // and display its nodes to the standard output
    public void showIndex() {
        for (String next : index) {
            System.out.println(next);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileInputStream("tinyTale.txt"));
         while (scanner.hasNextLine()) System.out.println(scanner.nextLine());


        // Once you've implemented and tested the methods in IndexGenerator,
        // UNCOMMENT THE FOLLOWING FOUR STATEMENTS:
        Scanner scan = new Scanner(new FileInputStream("tinyTale.txt"));

        IndexGenerator index = new IndexGenerator(); // an IndexGenerator instance
        index.buildTree(scan);                       // build a binary search tree
        index.showIndex();                           // display the tree nodes
    }
}
