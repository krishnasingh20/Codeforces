import java.util.*;
public class Seats {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      String s = sc.next();
      System.out.println(solve(n, s));
    }
    sc.close();
  }
  public static long solve(int n, String s) {
    long ans = 0;
    int c = 0;
    boolean prev = false;
    for(int i = 0; i < n; i++) {
      if(s.charAt(i) == '0') {
        c++;
      }
      else {
        c--;
        if(prev) {
          c--;
        }
        if(c > 0) {
          if(c % 3 != 0) {
            ans++;
          }
          ans += c/3;
        }
        ans++;
        prev = true;
        c = 0;
      }
    }
    if(c > 0) {
      if(prev) {
        c--;
      }
      if(c > 0) {
        if(c % 3 != 0) {
          ans++;
        }
        ans += (c/3);
      }
    }
    return ans;
  }
}
