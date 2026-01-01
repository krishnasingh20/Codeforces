import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      char[] ch = (sc.next()).toCharArray();
      System.out.println(solve(ch));
    }
    sc.close();
  }
  public static String solve(char[] ch) {
    int yes = 0;
    int no = 0;
    for(int i = 0; i < ch.length; i++) {
      if(ch[i] == 'Y') {
        yes++;
      }
    }
    if(yes > 1) {
      return "NO";
    }
    return "YES";
  }
}
