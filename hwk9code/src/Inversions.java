public class Inversions {

    public static void main(String[] args) {
        In in = new In("100Kints.txt");
        int n = in.readInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.readInt(); 
        }
        int[] aux = new int[n];
        //for (int i: a) System.out.print(i + " ");
        long startTime = System.currentTimeMillis();
        long inversionCount = getInversionCount(a, aux, 0, a.length-1);
        long endTime = System.currentTimeMillis();
        System.out.println("\nInversions: " + inversionCount);
        System.out.println((endTime - startTime) + " ms");
        //for (int i: a) System.out.print(i + " ");
    }

    private static long getInversionCount(int[] a, int[] aux, int lo, int hi) {
        long inversionCount = 0;
        if (hi <= lo) {
            return inversionCount;
        }
        int mid = lo + (hi - lo) / 2;
        inversionCount += getInversionCount(a, aux, lo, mid);
        inversionCount += getInversionCount(a, aux, mid + 1, hi);
        //YOUR CODE HERE
        inversionCount += merge(a, aux, lo, mid, hi);
        return inversionCount;
    }


    // MODIFY THIS METHOD SO THAT getInversionCount() COUNTS THE NUMBER
    // OF INVERSIONS CORRECTLY
    private static long merge(int[] a, int[] aux, int lo, int mid, int hi) {
        long inversionCount = 0;

        /*if (hi <= lo)
            return inversionCount;

        inversionCount += merge(a, aux, lo, (lo+mid)/2, mid);
        inversionCount += merge(a, aux, mid+1, (mid+1+hi)/2, hi);*/

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (aux[j] < aux[i])     {a[k] = aux[j++]; inversionCount += mid+1-i;}
            else                           a[k] = aux[i++];
        }

        return inversionCount;
    }
}
