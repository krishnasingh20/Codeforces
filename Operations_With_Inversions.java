import java.util.Scanner;
public class Main {
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
    int ans = 0;
    for(int i = n-2; i >= 0; i--) {
      for(int j = i+1; j < n; j++) {
        if(arr[j] != -1 && arr[j] < arr[i]) {
          ans++;
          arr[j] = -1;
        }
      }
    }
    return ans;
  }
}
