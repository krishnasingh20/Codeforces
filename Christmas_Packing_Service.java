import java.util.*;
public class Christmas_Packing_Service {
  public static void main(String... args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(solve(n, arr));
    }
  }
  public static long solve(int n, int[] arr) {
    int[] min = new int[n+1];
    min[n] = Integer.MAX_VALUE;
    min[n-1] = arr[n-1];
    for(int i = n - 2; i >= 0; i--) {
      min[i] = Math.min(min[i+1], arr[i]);
    }
    int ans = 0;
    for(int i = 0; i < n; i++) {
      if(arr[i] <= min[i+1]) {
        ans++;
      }
      else {
        arr[i+1] = Math.max(arr[i], arr[i+1]);
      }
    }
    return ans;
  }
}
