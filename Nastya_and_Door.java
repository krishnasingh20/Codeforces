import java.io.*;
import java.util.*;

public class Main {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    int T = 1;
    T = sc.nextInt();
    while (T-- > 0) {
        input();
    }
  }

  public static void input() {
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(solve(n, k, arr));
  }
  public static String solve(int n, int k, int[] arr) {
    int count = 0;
    int idx = 1;
    int ans = 0;
    for(int i = 1; i < k - 1; i++) {
      if(arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
        count++;
      }
    }
    if(count > ans) {
      ans = count;
      idx = 1;
    }
    for(int i = k; i < n; i++) {
      if(arr[i] < arr[i-1] && arr[i-1] > arr[i-2]) {
        count++;
      }
      int j = i - k + 1;
      if(j > 0) {
        if(arr[j] > arr[j-1] && arr[j] > arr[j+1]) {
          count--;
        }
      }
      if(count > ans) {
        ans = count;
        idx = i - k + 2;
      }
    }
    return (ans + 1)+" "+(idx);
  }
}
