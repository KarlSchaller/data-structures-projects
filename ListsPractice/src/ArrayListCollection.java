import java.util.ArrayList;

public class ArrayListCollection {

    public static void display(ArrayList list, String header) {
       System.out.println(header);
       for (int i = 0; i < list.size(); i++)
           list.get(i);
    }

    public static void main(String[] args) {

        ArrayList<String> items = new ArrayList;

        items.add("red");
        items.add(1, "yellow");
        items.add(Integer.toString(5));
        System.out.println("\n" + items + "\n");

        // header
        System.out.print(
                "Display list contents with counter-controlled loop: \n\n");

        // display the colors in the list
        for (int i = 0; i < items.size(); i++)
            System.out.printf(" %s\n", items.get(i));

        items.add("green");
        items.add("yellow");
        display(items, "List with two new elements: ");
    }
}
