import java.util.*;
public class BerSU_Ball {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for(int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    int m = sc.nextInt();
    int[] b = new int[m];
    for(int i = 0; i < m; i++) {
      b[i] = sc.nextInt();
    }
    System.out.println(solve(n, m, a, b));
    sc.close();
  }
  static Integer[][] dp;
  public static int solve(int n, int m, int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);
    dp = new Integer[n][m];
    return pair(a, b, 0, 0);
  }
  public static int pair(int[] a, int[] b, int i, int j) {
    if(i == a.length || j == b.length) {
      return 0;
    }
    if(dp[i][j] != null) {
      return dp[i][j];
    }
    int ans = 0;
    if(Math.abs(a[i]-b[j]) <= 1) {
      ans = 1 + pair(a, b, i+1, j+1);
    }
    else {
      int a1 = pair(a, b, i+1, j);
      int b1 = pair(a, b, i, j+1);
      ans = Math.max(a1, b1);
    }
    return dp[i][j] = ans;
  }
}
