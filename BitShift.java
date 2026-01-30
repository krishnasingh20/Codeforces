import java.util.*;
public class BitShift {
  public static void main(String... args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      String s = sc.next();
      int[] opr = new int[m];
      for(int i = 0; i < m; i++) {
        opr[i] = sc.nextInt();
      }
      System.out.println(solve(n, m, s, opr));
    }
  }
  public static String solve(int n, int m, String s, int[] opr) {
    long i = n-1;
    long j = n-1;
    for(int k = 0; k < m; k++) {
      if(opr[k] >= 0) {
        j = j + opr[k];
      }
      else {
        i = Math.min(i, j+opr[k]);
        j = j + opr[k];
        if(j < 0) {
          return "0";
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int k = 0; k <= Math.max(i, j); k++) {
      if(k > i) {
        sb.append('0');
      }
      else {
        sb.append(s.charAt(k));
      }
    }
    return sb.toString();
  }
}
