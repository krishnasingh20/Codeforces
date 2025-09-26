import java.util.*;
 
public class Unconventional_Pairs {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      long[] arr = new long[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
      }
      System.out.println(solve(n, arr));
    }
    sc.close();
  }
  public static long solve(int n, long[] arr) {
    Arrays.sort(arr);
    long ans = Long.MIN_VALUE;
    for(int i = 0; i < n; i += 2) {
      ans = Math.max(ans, (arr[i+1]-arr[i]));
    }
    return ans;
  }
  
}
