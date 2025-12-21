import java.util.*;
public class Optimal_Shift {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      String s = sc.next();
      System.out.println(solve(n, s.toCharArray()));
    }
    sc.close();
  }
  public static int solve(int n, char[] ch) {
    int ans = 0;
    int c = 0;
    for(int i = 0; i < n; i++) {
      if(ch[i] == '1') {
        ans = Math.max(ans, c);
        c = 0;
      }
      else {
        c++;
        ans = Math.max(ans, c);
      }
    }
    c = 0;
    int i = 0;
    while(i < n && ch[i] == '0') {
      c++;
      i++;
    }
    i = n - 1;
    while(i >= 0 && ch[i] == '0') {
      i--;
      c++;
    }
    ans = Math.max(ans, c);
    return ans;
  }
}
