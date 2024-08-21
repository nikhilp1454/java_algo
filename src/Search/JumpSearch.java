package Search;

class JumpSearch {
    public static int jumpSearch(int[] arr, int x) {
        int n = arr.length;

        int step = (int) Math.sqrt(n);

        int prev = 0;
        while (arr[Math.min(step, n) - 1] < x) {
            prev = step;
            step += (int) Math.sqrt(n);
            if (prev >= n) {
                return -1; // not present
            }
        }

        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == x) {
                return i;
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 7, 10, 13, 18, 23, 25, 29, 35, 40};
        int x = 18;

        int index = jumpSearch(arr, x);

        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + index);
        }
    }
}
