import java.util.Scanner;
import java.util.Arrays;
public class Offshores {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while(T-- > 0) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int y = sc.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(solve(n, x, y, arr));
    }
    sc.close();
  }
  public static long solve(int n, int x, int y, int[] arr) {
    long total = 0;
    for(int i = 0; i < n; i++) {
      total += (arr[i]/x);
    }
    long ans = 0;
    long curr = 0;
    for(int i = 0; i < n; i++) {
      long temp = curr*y;
      curr += (arr[i]/x);
      temp += (total - curr)*y;
      ans = Math.max(ans, temp+arr[i]);
    }
    return ans;
  }
}
