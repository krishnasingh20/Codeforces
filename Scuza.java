import java.util.*;

public class Scuza {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      long q = sc.nextLong();
      long[] arr = new long[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
      }
      long[] prefix = new long[n];
      long[] max = new long[n];
      max[0] = arr[0];
      prefix[0] = arr[0];
      for(int i = 1; i < n; i++) {
        prefix[i] = prefix[i-1]+arr[i];
        max[i] = Math.max(max[i-1], arr[i]);
      }
      while(q-- > 0) {
        long val = sc.nextLong();
        System.out.print(solve(n, prefix, max, val)+" ");
      }
      System.out.println();
    }
    sc.close();
  }
  public static long solve(int n, long[] prefix, long[] max, long val) {
    int low = 0;
    int high = n - 1;
    int ans = -1;
    while(low <= high) {
      int mid = low + (high - low)/2;
      if(max[mid] <= val) {
        ans =  mid;
        low = mid + 1;
      }
      else {
        high = mid - 1;
      }
    }
    if(ans != -1) {
      return prefix[ans];
    }
    return 0;
  }
}
