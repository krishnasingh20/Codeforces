import java.util.Scanner;
public class Count_Good_Number {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Count_Good_Number obj = new Count_Good_Number();
    int t = sc.nextInt();
    while(t-- > 0) {
      long l = sc.nextLong();
      long r = sc.nextLong();
      System.out.println(obj.solve(l, r));
    }
    sc.close();
  }
  Long[][][][][][] dp;
  private long solve(long l, long r) {
    dp = new Long[20][2][2][3][5][7];
    long ans_r = count(String.valueOf(r), 0, 1, 0, 0, 0, 0);
    dp = new Long[20][2][2][3][5][7];
    long ans_l = count(String.valueOf(l-1), 0, 1, 0, 0, 0, 0);
    return ans_r - ans_l;
  }
  private long count(String s, int i, int t, int r2, int r3, int r5, int r7) {
    if(i == s.length()) {
      if(r2 == 0 || r3 == 0 || r5 == 0 || r7 == 0) {
        return 0;
      }
      return 1;
    }
    if (t == 0 && dp[i][t][r2][r3][r5][r7] != null) {
      return dp[i][t][r2][r3][r5][r7];
    }
    int lb = 0;
    int ub = t==1?(s.charAt(i)-'0'):9;
    long ans = 0;
    for(int digit = lb; digit <= ub; digit++) {
      int newT = (t==1 && digit==ub)?1:0;
      int newR2 = (r2*10 + digit)%2;
      int newR3 = (r3*10 + digit)%3;
      int newR5 = (r5*10 + digit)%5;
      int newR7 = (r7*10 + digit)%7;
      ans += count(s, i+1, newT, newR2, newR3, newR5, newR7);
    }
    if (t == 0) {
      dp[i][t][r2][r3][r5][r7] = ans;
    }
    return ans;
  }
}
