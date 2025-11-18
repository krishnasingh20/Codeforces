import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int l = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.printf("%.10f\n", solve(n, l, arr));
  }
  public static double solve(int n, int l, int[] arr) {
    Arrays.sort(arr);
    double ans = 0.0;
    double low = 0.0;
    double high = l;
    for(int i = 0; i <= 100; i++) {
      double mid = low + (high - low) / 2.0;
      if(possible(mid, l, arr)) {
        ans = mid;
        high = mid;
      }
      else {
        low = mid;
      }
    }
    return ans;
  }
  public static boolean possible(double mid, int l, int[] arr) {
    double curr = 0.0;
    for(int i = 0; i < arr.length; i++) {
      if((double)arr[i] - mid > curr) {
        return false;
      }
      curr = (double)arr[i] + mid;
    }
    return curr >= l*1.0;
  }
}
