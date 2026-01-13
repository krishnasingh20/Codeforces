import java.util.*;
public class Circle_of_Apple_Trees {
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
    Arrays.sort(arr);
    int ans = 1;
    for(int i = 1; i < n; i++) {
      if(arr[i] > arr[i-1]) {
        ans++;
      }
    }
    return ans;
  }
}
