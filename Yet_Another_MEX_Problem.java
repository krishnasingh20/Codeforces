import java.util.*;
public class Yet_Another_MEX_Problem {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(solve(n, k, arr));
    }
    sc.close();
  }
  public static int solve(int n, int k, int[] arr) {
    HashSet<Integer> set = new HashSet<>();
    for(int i = 0; i < n; i++) {
      set.add(arr[i]);
    }
    for(int i = 0; i < k-1; i++) {
      if(!set.contains(i)) {
        return i;
      }
    }
    return k-1;
  }
}
