import java.util.*;
public class Array_Coloring {
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
  }
  public static String solve(int n, int[] arr) {
    int[] a = new int[n];
    for(int i = 1; i < n; i += 2) {
      a[i] = 1;
    }
    boolean flag = false;
    for(int i = 1; i < n; i++) {
      if(a[arr[i-1]-1] == a[arr[i]-1]) {
        flag = true;
        break;
      }
    }
    if(!flag) {
      return "YES";
    }
    flag = false;
    a = new int[n];
    for(int i = 0; i < n; i += 2) {
      a[i] = 1;
    }
    for(int i = 1; i < n; i++) {
      if(a[arr[i-1]-1] == a[arr[i]-1]) {
        flag = true;
        break;
      }
    }
    if(!flag) {
      return "YES";
    }
    return "NO";
  }
}
