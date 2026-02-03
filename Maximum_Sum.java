import java.util.*;
public class Maximum_Sum {
  public static void main(String[] args) {
    Maximum_Sum obj = new Maximum_Sum();
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(obj.solve(n, k, arr));
    }
    sc.close();
  }
  private long solve(int n, int k, int[] arr) {
    Arrays.sort(arr);
    long[] prefix = new long[n+1];
    for(int i = 1; i <= n; i++) {
      prefix[i] = prefix[i-1] + arr[i-1];
    }
    long ans = 0;
    for(int i = 0; i <= k; i++) {
      long curr = prefix[n-(k-i)] - prefix[2*i];
      ans = Math.max(ans, curr);
    }
    return ans;
  }
}
