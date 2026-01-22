import java.util.*;
public class Make_it_Zigzag {
  public static void main(String[] args) {
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
    sc.close();
  }
  public static int solve(int n, int[] arr) {
    int max = arr[0];
    for(int i = 1; i < n; i++) {
      max = Math.max(max, arr[i]);
      if((i & 1) == 1) {
        arr[i] = max;
      }
    }
    int ans = 0;
    for(int i = 0; i < n - 1; i++) {
      if((i & 1) == 0) {
        if(arr[i] >= arr[i+1]) {
          ans += (arr[i]-arr[i+1]+1);
          arr[i] = arr[i+1]-1;
        }
      }
      else {
        if(arr[i] <= arr[i+1]) {
          ans += (arr[i+1]-arr[i]+1);
          arr[i+1] = arr[i]-1;
        }
      }
    }
    return ans;
  }
}
