import java.util.*;
public class Impost_or_Sus {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      char[] ch = (sc.next()).toCharArray();
      System.out.println(solve(ch));
    }
    sc.close();
  }
  public static int solve(char[] ch) {
    int n = ch.length;
    int minOpe = 0;
    if(ch[0] == 'u') {
      ch[0] = 's';
      minOpe++;
    }
    if(ch[n-1] == 'u') {
      ch[n-1] = 's';
      minOpe++;
    }
    for(int i = 1; i < n-1; i++) {
      if(ch[i] == 'u') {
        if(ch[i+1] != 's') {
          ch[i+1] = 's';
          minOpe++;
        }
      }
    }
    return minOpe;
  }
}
