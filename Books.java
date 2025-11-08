import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    // int T = in.nextInt();
    int T = 1;
    while (T-- > 0) {
        input();
    }
  }

  public static void input() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long t = sc.nextLong();
    long[] arr = new long[n];
    for(int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
    }
    System.out.println(solve(n, t, arr));
  }
  public static int solve(int n, long t, long[] arr) {
    int ans = 0;
    int left = 0;
    long curr = 0;
    for(int right = 0; right < n; right++) {
      curr += arr[right];
      while(curr > t) {
        curr -= arr[left];
        left++;
      }
      ans = Math.max(ans, (right - left + 1));
    }
    return ans;
  }
}
