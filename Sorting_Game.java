import java.util.*;
public class Sorting_Game {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      String s = sc.next();
      char[] ch = s.toCharArray();
      solve(n, ch);
    }
  }
  public static void solve(int n, char[] ch) {
    int zero = 0;
    int one = 0;
    for(int i = 0; i < n; i++) {
      if(ch[i] == '0') {
        zero++;
      }
      else {
        one++;
      }
    }
    char[] newCh = new char[n];
    for(int i = 0; i < n; i++) {
      if(zero > 0) {
        newCh[i]= '0';
        zero--;
      }
      else {
        newCh[i] = '1';
        one--;
      }
    }
    StringBuilder sb = new StringBuilder();
    boolean flag = false;
    int m = 0;
    for(int i = 0; i < n; i++) {
      if(ch[i] != newCh[i]) {
        flag = true;
        sb.append((i+1)).append(" ");
        m++;
      }
    }
    if(!flag) {
      System.out.println("Bob");
      return;
    }
    System.out.println("Alice");
    System.out.println(m);
    System.out.println(sb.toString());
  }
}
