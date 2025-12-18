import java.util.*;
public class Main {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
      int T = sc.nextInt();
      while (T-- > 0) {
          input();
      }
  }
  public static void input() {
      String s = sc.next();
      System.out.println(solve(s));
  } 
  public static int solve(String s) {
    if(s.length() == 1) {
      return 1;
    }
    char[] ch = s.toCharArray();
    int left = 0;
    int right = 0;
    int c1 = 0;
    int c2 = 0;
    int c3 = 0;
    int n = ch.length;
    for(int i = 0; i < n; i++) {
      if(ch[i] == '<') {
        c1++;
        left = Math.max(left, c1);
        c2 = 0;
      }
      else if(ch[i] == '>') {
        c2++;
        if(c3 == 1) {
          right = Math.max(right, c2+1);
        }
        right = Math.max(right, c2);
        c1 = 0;
        if(i+1 < n && ch[i+1] == '<') {
          return -1;
        }
        else if(i+1 < n && ch[i+1] == '*') {
          return -1;
        }
      }
      else {
        if(i > 0) {
          if(i+1 < n) {
            if(ch[i-1] == '>' && ch[i+1] == '<') {
              return -1;
            }
            if(ch[i+1] == '<') {
              return -1;
            }
          }
          if(ch[i-1] == '*') {
            return -1;
          }
        }
        else if(i+1 < n && (ch[i+1] == '<' || ch[i+1] == '*')) {
          return -1;
        }
        c3 = 1;
        left = Math.max(left, c1+1);
      }
    }
    return Math.max(left, right);
  }
}
