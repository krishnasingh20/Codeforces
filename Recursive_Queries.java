import java.io.*;
import java.util.*;

public class Main {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    int T = 1;
    // T = sc.nextInt();
    while (T-- > 0) {
        input();
    }
  }

  public static void input() {
    int q = sc.nextInt();
    int[][] arr = new int[q][3];
    int max = 0;
    int min = 10000000;
    for(int i = 0; i < q; i++) {
      arr[i][0] = sc.nextInt();
      arr[i][1] = sc.nextInt();
      arr[i][2] = sc.nextInt();
      max = Math.max(max, arr[i][1]);
      min = Math.min(min, arr[i][0]);
    }
    solve(q, arr, max, min);
  }
  public static void solve(int q, int[][] arr, int max, int min) {
    int[][] pre = new int[max+1][10];
    for(int i = min; i <= max; i++) {
      int val = (int)find((long)i);
      pre[i][val]++;
    }
    for(int i = min; i < max+1; i++) {
      for(int j = 1; j < 10; j++) {
        pre[i][j] += pre[i-1][j];
      }
    }
    for(int i = 0; i < q; i++) {
      int a = pre[arr[i][1]][arr[i][2]] - pre[arr[i][0]-1][arr[i][2]];
      System.out.println(a);
    }
  }
  public static long find(long val) {
    if(val < 10) {
      return val;
    }
    long p = 1;
    while(val > 0) {
      long rem = val % 10;
      if(rem > 0) {
        p *= rem;
      }
      val /= 10;
    }
    return find(p);
  }
}
