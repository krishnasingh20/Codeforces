import java.util.*;
public class Letter {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    char[][] grid = new char[n][m];
    for(int i = 0; i < n; i++) {
      String s = sc.next();
      for(int j = 0; j < m; j++) {
        grid[i][j] = s.charAt(j);
      }
    }
    System.out.println(solve(n, m, grid));
  }
  public static String solve(int n, int m, char[][] grid) {
    int minR = Integer.MAX_VALUE;
    int minC = Integer.MAX_VALUE;
    int maxR = Integer.MIN_VALUE;
    int maxC = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        if(grid[i][j] == '*') {
          minR = Math.min(minR, i);
          minC = Math.min(minC, j);
          maxR = Math.max(maxR, i);
          maxC = Math.max(maxC, j);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int i = minR; i <= maxR; i++) {
      for(int j = minC; j <= maxC; j++) {
        sb.append(grid[i][j]);
      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
