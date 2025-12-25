import java.util.Scanner;
public class Blackslex_and_Number_Theory {
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
    int min = Integer.MAX_VALUE;
    for(int a: arr) {
      min = Math.min(min, a);
    }
    int diff = Integer.MAX_VALUE;
    for(int a: arr) {
      if(a == min) {
        continue;
      }
      if(a-min < min) {
        return min;
      }
      diff = Math.min(diff, a-min);
    }
    return diff;
  }
}
