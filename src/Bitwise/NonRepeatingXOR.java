package Bitwise;

import java.util.*;

public class NonRepeatingXOR {
    public static int[] get2NonRepeatingNos(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;

        int[] rets = new int[2]; 
        Arrays.fill(rets, 0);
        for (int num : nums) {
            if ((num & diff) == 0) {
                rets[0] ^= num;
            } else {
                rets[1] ^= num;
            }
        }
        if (rets[0] > rets[1]) {
            int temp = rets[0];
            rets[0] = rets[1];
            rets[1] = temp;
        }

        return rets;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 9, 11, 2, 3, 11};
        int[] result = get2NonRepeatingNos(arr);
        System.out.println("The non-repeating elements are " + result[0] + " and " + result[1]);
    }
}
