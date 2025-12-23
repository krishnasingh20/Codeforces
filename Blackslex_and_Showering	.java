import java.util.*;
public class Blackslex_and_Showering {
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
  }
  public static long solve(int n, int[] arr) {
    long diff = 0;
    for(int i = 0; i < n - 1; i++) {
      diff += Math.abs(arr[i] - arr[i+1]);
    }
    int curr = 0;
    for(int i = 0; i < n; i++) {
      if(i == 0) {
        curr = Math.max(curr, Math.abs(arr[i]-arr[i+1]));
      }
      else if(i == n-1) {
        curr = Math.max(curr, Math.abs(arr[i] - arr[i-1]));
      }
      else {
        curr = Math.max(curr, Math.abs(arr[i]-arr[i-1])+Math.abs(arr[i]-arr[i+1])-Math.abs(arr[i-1]-arr[i+1]));
      }
    }
    return diff-curr;
  }
}
