import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      long k = sc.nextLong();
      long q = sc.nextLong();
      long[] arr = new long[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
      }
      System.out.println(solve(n, k, q, arr));
    }
    sc.close();
  }
  public static long solve(int n, long k, long q, long[] arr) {
    long ans = 0;
    int i = 0;
    int j = 0;
    while(j < n) {
      if(arr[j] > q) {
        if((j-i) >= k) {
          long len = (j-i);
          long a = ((len - k + 1)*(len-k+2))/2;
          ans += a;
        }
        i = j+1;
      }
      j++;
    }
    if((j-i) >= k) {
      long len = (j-i);
      long a = ((len - k + 1)*(len-k+2))/2;
      ans += a;
    }
    return ans;
  }
}
