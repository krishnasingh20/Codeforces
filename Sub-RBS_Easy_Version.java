import java.util.*;
public class Sub-RBS_(Easy Version) {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      String s = sc.next();
      char[] ch = s.toCharArray();
      System.out.println(solve(n, ch));
    }
  }
  public static int solve(int n, char[] ch) {
    int open = 0;
    int idx = -1;
    for(int i = 0; i < n; i++) {
      if(ch[i] == ')') {
        idx = i;
        break;
      }
      if(ch[i] == '(') {
        open++;
      }
    }
    int ans = 0;
    for(int i = idx+1; i < n; i++) {
      if(ch[i] == '(') {
        open++;
      }
      else {
        if(open > 0) {
          ans += 2;
          open--;
        }
      }
    }
    if(ans/2 >= idx+1) {
      return ans;
    }
    return -1;
  }
}
