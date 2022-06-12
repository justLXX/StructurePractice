package bilibili;


public class P4 {
    public static void main(String[] args) {

        int[] arr = {3, 2, 4, 6, 5, 7, 8, 1};

        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) return;

        int mid = L + ((R - L) >> 1);

        process(arr, L, mid);
        process(arr, mid + 1, R);
        System.out.println();
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        System.out.println("l = " + l + "  r = " + r + "  m = " + m);
        System.out.print("初步排序的arr:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

        int[] help = new int[r - l + 1];

        int i = 0;
        int p1 = l;
        int p2 = m + 1;

        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

        System.out.print("排序后的arr:");
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

}
