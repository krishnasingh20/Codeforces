import java.util.*;
public class Restricted_Sorting {
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
  public static long solve(int n, int[] arr) {
    int[] newArr = arr.clone();
    Arrays.sort(newArr);
    int idx = -1;
    for(int i = 0; i < n; i++) {
      if(arr[i] != newArr[i]) {
        idx = i;
        break;
      }
    }
    if(idx == -1) {
      return idx;
    }
    long ans = Long.MAX_VALUE;
    int min = newArr[0];
    int max = newArr[n-1];
    for(int i = 0; i < n; i++) {
      if(arr[i] == newArr[i]) {
        continue;
      }
      ans = Math.min(ans, Math.max(Math.abs(arr[i]-min), Math.abs(arr[i]-max)));
    }
    return ans;
  }
}
