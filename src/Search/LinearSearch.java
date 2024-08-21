package Search;

class LinearSearch {
	public static int search(int arr[], int N, int x) {
		for (int i = 0; i < N; i++) {
			if (arr[i] == x)
				return i;
		}
		return -1;
	}

	public static void main(String args[]) {
		int arr[] = {1,4,8,23,66 };
		int x = 10;

		int result = search(arr, arr.length, x);
		if (result == -1)
			System.out.print("Not present");
		else
			System.out.print("Present at index " + result);
	}
}
