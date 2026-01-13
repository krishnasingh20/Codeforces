import java.util.*;
public class Bitwise_Reversion {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      long x = sc.nextLong();
      long y = sc.nextLong();
      long z = sc.nextLong();
      System.out.println(solve(x, y, z));
    }
    sc.close();
  }
  public static String solve(long x, long y, long z) {
    long a = (x | z);
    long b = (x | y);
    long c = (y | z);
    if((a & b) != x || (b & c) != y || (a & c) != z) {
      return "NO";
    }
    return "YES";
  }
}
