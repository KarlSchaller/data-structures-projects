public class OrderedListTest2 {
    public static void main(String[] args) {
        OrderedList<String> list = new OrderedList<>();
        list.add("George");
        list.add("Bill");
        list.add("Barack");
        list.add("Don");

        // print the list
        for (String s : list) {
            System.out.print(s + " "); // prints Barack Bill Don George (alphabetical by default)
        }
        System.out.println();
    }
}