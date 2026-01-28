import java.util.*;
public class MEX_Count {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int[] count = new int[n+1];
      for(int i = 0; i < n; i++) {
        int x = sc.nextInt();
        count[x]++;
      }
      System.out.println(solve(n, count));
    }
    sc.close();
  }
  public static String solve(int n, int[] count) {
    int[] ans = new int[n+2];//in these i am counting answer for indivisual contributions
    int extra = 0;
    int curr = 0;
    for(int i = 0; i <= n; i++) {
      curr += count[i];
      if(count[i] == 0) {
        int l = 0;
        int r = (n-curr) + extra + 1;
        ans[l] += 1;
        ans[r] -= 1;
        break;
      }
      int l = count[i];
      int r = count[i]+extra+(n-curr)+1;
      ans[l] += 1;
      ans[r] -= 1;
      extra += Math.max(0, count[i]-1);
    }
    for(int i = 1; i <=n+1; i++) {
      ans[i] += ans[i-1];
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i <= n; i++) {
      sb.append(ans[i]).append(" ");
    }
    return sb.toString();
  }
}
