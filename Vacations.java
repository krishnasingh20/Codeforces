import java.util.Scanner;
import java.util.Arrays;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // int t = sc.nextInt();
    int t = 1;
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
    int[][] dp = new int[n][3];
    for(int[] d: dp) {
      Arrays.fill(d, -1);
    }
    return vacation(arr, 0, 0, dp);
  }
  public static int vacation(int[] arr, int i, int state, int[][] dp) {
    if(i == arr.length) {
      return 0;
    }
    if(dp[i][state] != -1) {
      return dp[i][state];
    }
    int ans = 0;
    if(arr[i] == 0) {
      return dp[i][state] = 1 + vacation(arr, i+1, 0, dp);
    }
    else {
      if(state == 0) {
        if(arr[i] == 1) {
          int a = vacation(arr, i+1, 2, dp);
          ans = a;
        }
        else if(arr[i] == 2) {
          int b = vacation(arr, i+1, 1, dp);
          ans = b;
        }
        else {
          int a = vacation(arr, i+1, 1, dp);
          int b = vacation(arr, i+1, 2, dp);
          ans = Math.min(a, b);
        }
      }
      else if(state == 1) {
        if(arr[i] == 1) {
          int a = vacation(arr, i+1, 2, dp);
          ans = a;
        }
        else if(arr[i] == 2) {
          int b = 1 + vacation(arr, i+1, 0, dp);
          ans = b;
        }
        else {
          int a = vacation(arr, i+1, 2, dp);
          ans = a;
        }
      }
      else {
        if(arr[i] == 1) {
          int a = 1 + vacation(arr, i+1, 0, dp);
          ans = a;
        }
        else if(arr[i] == 2) {
          int a = vacation(arr, i+1, 1, dp);
          ans = a;
        }
        else {
          int a = vacation(arr, i+1, 1, dp);
          ans = a;
        }
      }
    }
    return dp[i][state] = ans;
  }
}
