import java.util.*;
public class Journey_Planning {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long[] arr = new long[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextLong();
    }
    System.out.println(solve(n, arr));
  }
  public static long solve(int n, long[] arr) {
    HashMap<Long, Long> map = new HashMap<>();
    long ans = 0;
    for(int i = 0; i < n; i++) {
      long curr = (i+1) - arr[i];
      map.put(curr, map.getOrDefault(curr, 0L)+arr[i]);
      ans = Math.max(ans, map.get(curr));
    }
    return ans;
  }
}
