import java.util.*;
public class Arrow_Path {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      String r1 = sc.next();
      String r2 = sc.next();
      int[][] grid = new int[2][n];
      for(int i = 0; i < n; i++) {
        if(r1.charAt(i) == '>') {
          grid[0][i] = 0;
        }
        else {
          grid[0][i] = 1;
        }
      }
      for(int i = 0; i < n; i++) {
        if(r2.charAt(i) == '>') {
          grid[1][i] = 0;
        }
        else {
          grid[1][i] = 1;
        }
      }
      System.out.println((solve(n, grid)?"YES":"NO"));
    }
    sc.close();
  }
  static Boolean[][] dp;
  public static boolean solve(int n, int[][] grid) {
    dp = new Boolean[2][n];
    return path(0, 0, grid);
  }
  public static boolean path(int r, int c, int[][] grid) {
    if(r == 1 && c == grid[0].length-1) {
      return true;
    }
    if(r < 0 || r > 1 || c < 0 || c >= grid[0].length) {
      return false;
    }
    if(dp[r][c] != null) {
      return dp[r][c];
    }
    dp[r][c] = false;//avoid revisiting the same cell
    boolean ans = false;
    if(r+1 <= 1) {//down
      int curr = grid[r+1][c];
      int newC = curr==0?c+1:c-1;
      ans = ans || path(r+1, newC, grid);
    }
    if(r-1 >= 0) {//up
      int curr = grid[r-1][c];
      int newC = curr==0?c+1:c-1;
      ans = ans || path(r-1, newC, grid);
    }
    if(c-1 >= 0) {//left
      int curr = grid[r][c-1];
      int newC = curr==0?c:c-2;
      ans = ans || path(r, newC, grid);
    }
    if(c+1 < grid[0].length) {//right
      int curr = grid[r][c+1];
      int newC = curr==0?c+2:c;
      ans = ans || path(r, newC, grid);
    }
    return dp[r][c] = ans;
  }
}
