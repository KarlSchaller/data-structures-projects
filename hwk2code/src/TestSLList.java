// Unit tests for the SLList class (add more tests)
public class TestSLList {
    public static void main(String[] args) {
        SLList<String> list = new SLList<>();

        list.insertAtFront("Bob");
        list.print();
        list.insertAtFront("Alice");
        list.print();
        list.insertAtBack("Wey");
        list.print();
        list.insertAtBack("Xanadu");
        list.print();
        list.insertAtBack("Zorro");
        list.print();

        String removedItem = list.removeFromFront();
        System.out.printf("\n%s removed\n", removedItem);
        System.out.printf(" The list is now ");
        list.print();

        removedItem = list.removeFromBack();
        System.out.printf("\n%s removed\n", removedItem);
        System.out.printf(" The list is now ");
        list.print();

        removedItem = list.removeFromBack();
        System.out.printf("\n%s removed\n", removedItem);
        System.out.printf(" The list is now ");
        list.print();
    }
}
