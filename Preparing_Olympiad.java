import java.util.*;
public class Preparing_Olympiad {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int l = sc.nextInt();
    int r = sc.nextInt();
    int x = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(solve(n, l, r, x, arr));
  }
  public static long solve(int n, int l, int r, int x, int[] arr) {
    int ans = 0;
    for(int i = 3; i < (1<<n); i++) {
      if(setBitCount(i) >= 2 && isPossible(i, l, r, x, arr)) {
        ans++;
      }
    }
    return ans;
  }
  public static boolean isPossible(int i, int l, int r, int x, int[] arr) {
    long min = Integer.MAX_VALUE;
    long max = Integer.MIN_VALUE;
    long sum = 0;
    int idx = 0;
    while(i > 0) {
      if((i & 1) == 1) {
        sum += arr[idx];
        min = Math.min(min, arr[idx]);
        max = Math.max(max, arr[idx]);
      }
      idx++;
      i >>= 1;
    }
    return (sum >= l & sum <= r & (max-min) >= x);
  }
  public static int setBitCount(int n) {
    int c = 0;
    while(n > 0) {
      c++;
      n = n & (n-1);
    }
    return c;
  }
}
