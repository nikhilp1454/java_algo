package Bitwise;

class SwapBits {

	static int swapBits(int x, int p1, int p2, int n)
	{
		int set1 = (x >> p1) & ((1 << n) - 1);

		int set2 = (x >> p2) & ((1 << n) - 1);

		int xor = (set1 ^ set2);

		xor = (xor << p1) | (xor << p2);
		int result = x ^ xor;

		return result;
	}

	public static void main(String[] args)
	{
		int res = swapBits(28, 0, 3, 2);
		System.out.println("Result = " + res);
	}
}

