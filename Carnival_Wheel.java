import java.util.*;
public class Carnival_Wheel {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      long l = sc.nextLong();
      long a = sc.nextLong();
      long b = sc.nextLong();
      System.out.println(solve(l, a, b));
    }
    sc.close();
  }
  public static long solve(long l, long a, long b) {
    HashSet<Long> set = new HashSet<>();
    long ans = a;
    while(!set.contains(a)) {
      ans = Math.max(ans, a);
      set.add(a);
      a = (a + b) % l;
    }
    return ans;
  }
}
