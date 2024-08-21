package Bitwise;


class CountTotal {
 static int countSetBits(int n)
 {
     int count = 0;
     while (n > 0) {
         count += n & 1;
         n >>= 1;
     }
     return count;
 }
 static int countAllSetBits(int n)
 {
     int res = 0;
     for (int i = 1; i <= n; i++)
         res += countSetBits(i);
     return res;
 }
 public static void main(String args[])
 {
     int n = 6;
     System.out.println(countAllSetBits(n));
 }
}
