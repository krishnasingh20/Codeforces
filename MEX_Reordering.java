import java.util.*;
public class MEX_Reordering {
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
    Arrays.sort(arr);
    int c = 0;
    for(int i = 0; i < n-1; i++) {
      if(arr[i] == c) {
        c++;
      }
      int c1 = 0;
      for(int j = i+1; j < n; j++) {
        if(arr[j] == c1) {
          c1++;
        }
      }
      if(c == c1) {
        return "NO";
      }
    }
    return "YES";
  }
}
