import java.util.*;
public class Queue_Sort {
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
    int idx = -1;
    for(int i = n-1; i > 0; i--) {
      if(arr[i] < arr[i-1]) {
        idx = i;
        break;
      }
    }
    if(idx == -1) {
      return 0;
    }
    for(int i = 0; i < idx; i++) {
      if(arr[i] <= arr[idx]) {
        return -1;
      }
    }
    return idx;
  }
}
