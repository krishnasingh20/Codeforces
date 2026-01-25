import java.util.*;
public class Monster_Game {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      for(int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      for(int i = 0; i < n; i++) {
        b[i] = sc.nextInt();
      }
      System.out.println(solve(n, a, b));
    }
  }
  public static long solve(int n, int[] a, int[] b) {
    long[] prefixSum = new long[n];
    prefixSum[0] = b[0];
    for(int i = 1; i < n; i++) {
      prefixSum[i] = prefixSum[i-1] + b[i];
    }
    long ans = 0;
    Arrays.sort(a);
    for(int i = 0; i < n; i++) {
      int level = find(prefixSum, (n-i));
      ans = Math.max(ans, (long)a[i]*level);
    }
    return ans;
  }
  public static int find(long[] prefixSum, int target) {
    int idx = -1;
    int low = 0;
    int high = prefixSum.length-1;
    while(low <= high) {
      int mid = low + (high-low)/2;
      if(prefixSum[mid] <= target) {
        idx = mid;
        low = mid + 1;
      }
      else {
        high = mid - 1;
      }
    }
    return idx+1;
  }
}
