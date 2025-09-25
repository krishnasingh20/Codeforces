import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      long x = sc.nextLong();
      long y = sc.nextLong();
      long[] arr = new long[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
      }
      System.out.println(solve(n, x, y, arr));
    }
    sc.close();
  }
  public static long solve(int n, long x, long y, long[] arr) {
    Arrays.sort(arr);
    long sum = 0;
    for(long a: arr) {
      sum += a;
    }
    long ans = 0;
    for(int i = 1; i < n; i++) {
      int idx1 = upperBound(arr, x, sum, i);
      int idx2 = lowerBound(arr, y, sum, i);
      if(idx1 != -1 && idx2 != -1) {
        ans += (idx1 - idx2 + 1);
      }
    }
    return ans;
  }
  public static int upperBound(long[] arr, long x, long sum, int i) {
    int low = 0;
    int high = i - 1;
    int idx = -1;
    while(low <= high) {
      int mid = low + (high - low)/2;
      long target = sum - (arr[i]+arr[mid]);
      if(target >= x) {
        idx = mid;
        low = mid + 1;
      }
      else {
        high = mid - 1;
      }
    }
    return idx;
  }
  public static int lowerBound(long[] arr, long y, long sum, int i) {
    int low = 0;
    int high = i - 1;
    int idx = -1;
    while(low <= high) {
      int mid = low + (high - low)/2;
      long target = sum - (arr[i]+arr[mid]);
      if(target <= y ) {
        idx = mid;
        high = mid - 1;
      }
      else {
        low = mid + 1;
      }
    }
    return idx;
  }
}
// i have sort the array so that it will be s=easy for me to find that number of pairs, and used 
// upperbound to find maximum index less then i that is greater then equal to x and used find 
// minimum indix which is less then equal to yusing binary search in O(log(n)).
// here we are using y as to find lower bound because when we subtarct minimum value
// from sum it will be more so y is on larger side and same for x that we need min value
// greater then equal to x so that condition satisfy and upper value are higher or larger
