package Bitwise;

class BitwiseAND {
	static int find_and(int arr[])
	{
		int ans = arr[0];
		for (int i = 0; i < arr.length; i++)
			ans = (ans & arr[i]);
		return ans;
	}
	public static void main(String args[])
	{
		int arr[] = { 1, 3, 5, 9, 11 };
		System.out.println(find_and(arr));
	}
}
