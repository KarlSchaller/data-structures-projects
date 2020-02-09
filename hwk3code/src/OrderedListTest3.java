public class OrderedListTest3 {
    public static void main(String[] args) {
        OrderedList<President> list = new OrderedList<>();

        // list of a few recent presidents
        President jimmy = new President("Jimmy", 1976);
        President ronny = new President("Ronald", 1980);
        President georgeH = new President("George-H", 1988);
        President bill = new President("Bill", 1992);
        President georgeW = new President("George-W", 2000);
        President barack  = new President("Barack", 2008);
        President don  = new President("Donald", 2016);

        list.add(bill);
        list.add(georgeW);
        list.add(georgeH);
        list.add(ronny);
        list.add(barack);

        for (President president : list) {
            System.out.println(president + " ");
        }
        System.out.println();
    }
}
