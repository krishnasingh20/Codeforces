import java.util.*;
 
public class All_Length_Subtraction {
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
    int k = 1;
    int val = n;
    while(k <= n) {
      int idx = -1;
      for(int i = 0; i < n; i++) {
        if(arr[i] == val) {
          idx = i;
          break;
        }
      }
      if(idx+k > n) {
        return "NO";
      }
      for(int j = idx; j < idx + k && j < n; j++) {
        if(arr[j] != val) {
          return "NO";
        }
        arr[j]--;
      }
      val--;
      k++;
    }
    return "YES";
  }
}
