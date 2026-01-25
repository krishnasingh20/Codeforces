import java.util.*;
public class DBMB_and_the_Array {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int s = sc.nextInt();
      int x = sc.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(solve(n, s, x, arr));
    }
  }
  public static String solve(int n, int s, int x, int[] arr) {
    int sum = 0;
    for(int a: arr) {
      sum += a;
    }
    if(sum == s) {
      return "YES";
    }
    if(sum > s) {
      return "NO";
    }
    if((s-sum) % x == 0) {
      return "YES";
    }
    return "NO";
  }
}
