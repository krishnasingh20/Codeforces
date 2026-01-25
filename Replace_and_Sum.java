import java.util.*;
public class Replace_and_Sum {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      for(int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      for(int i = 0; i < n; i++) {
        b[i] = sc.nextInt();
      }
      System.out.println(solve(n, q, a, b));
    }
  }
  public static String solve(int n,int q, int[] a, int[] b) {
    for(int i = 0; i < n; i++) {
      a[i] = Math.max(a[i], b[i]);
    }
    for(int i = n-2; i >= 0; i--) {
      a[i] = Math.max(a[i], a[i+1]);
    }
    long[] prefix = new long[n+1];
    for(int i = 0; i < n; i++) {
      prefix[i+1] = prefix[i] + a[i];
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < q; i++) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      sb.append((prefix[r]-prefix[l-1])).append(" ");
    }
    return sb.toString();
  }
}
