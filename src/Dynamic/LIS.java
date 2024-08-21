package Dynamic;
//longest increasing subseq
import java.util.*;

class LIS {
    static int lisEndAtI(int[] arr, int i) {
        if (i == 0)
            return 1;

        int mx = 1;
        for (int prev = 0; prev < i; prev++)
            if (arr[prev] < arr[i])
                mx = Math.max(mx, lisEndAtI(arr, prev) + 1);
        return mx;
    }

    static int lis(int[] arr) {
        int n = arr.length;
        int res = 1;
        for (int i = 1; i < n; i++)
            res = Math.max(res, lisEndAtI(arr, i));
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};

        System.out.println("Length of LIS is " + lis(arr));
    }
}
