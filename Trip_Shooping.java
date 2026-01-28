import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[][] arr = new int[n][2];
      for(int i = 0; i < n; i++) {
        arr[i][0] = sc.nextInt();
      }
      for(int i = 0; i < n; i++) {
        arr[i][1] = sc.nextInt();
      }
      System.out.println(solve(n, k, arr));
    }
    sc.close();
  }
  public static long solve(int n, int k, int[][] arr) {
    Arrays.sort(arr, (a, b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
    long ans = 0;
    for(int i = 0; i < n; i++) {
      ans += Math.abs(arr[i][0]-arr[i][1]);
    }
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < n-1; i++) {
      int a = Math.abs(arr[i][0]-arr[i+1][0])+Math.abs(arr[i][1]-arr[i+1][1]);
      int b = Math.abs(arr[i][0]-arr[i+1][1])+Math.abs(arr[i][1]-arr[i+1][0]);
      int curr = Math.max(a, b);
      int org = Math.abs(arr[i][0]-arr[i][1])+Math.abs(arr[i+1][0]-arr[i+1][1]);
      if(curr <= org) {//Ali will always choose these one to minimize the v
        min = -1;
        break;
      }
      if(curr > org) {
        min = Math.min(min, curr-org);
      }
    }
    if(min == -1) {
      return ans;
    }
    return ans+min;
  }
}
