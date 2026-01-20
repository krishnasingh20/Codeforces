import java.util.*;

public class Love_A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    System.out.println(solve(s));
    sc.close();
  }
  public static int solve(String s) {
    int c = 0;
    int n = s.length();
    for(int i = 0; i < n; i++) {
      if(s.charAt(i) == 'a') {
        c++;
      }
    }
    if(c > n/2) {
      return n;
    }
    while(n/2 >= c) {
      n--;
    }
    return n;
  }
}
