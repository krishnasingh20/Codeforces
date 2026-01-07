import java.util.*;
public class Binary_Array_Game {
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
  public static String solve(int n, int[] arr) {
    if(arr[n-1] == 1 || arr[0] == 1) {
      return "Alice";
    }
    return "Bob";
  }
}
