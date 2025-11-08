import java.io.*;
import java.util.*;

public class Main {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    int T = sc.nextInt();
    // T = 1;
    while (T-- > 0) {
        input();
    }
  }

  public static void input() {
    int n = sc.nextInt();
    long k = sc.nextLong();
    String s = sc.next();
    System.out.println(solve(n, k, s));
  }
  public static String solve(int n, long k, String s) {
    char[] ch = s.toCharArray();
    int one = 0;
    for(int i = 0; i < n; i++) {
      if(ch[i] == '0') {
        if(one <= k) {
          ch[i] = '1';
          ch[i-one] = '0';
          k -= one;
        }
        else {
          ch[i-(int)k] = '0';
          ch[i] = '1';
          k = 0;
        }
      }
      else {
        one++;
      }
      if(k == 0) {
        break;
      }
    }
    return new String(ch);
  }
}
