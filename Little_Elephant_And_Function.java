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
    int n = sc.nextInt();
    System.out.println(solve(n));
  }
  public static String solve(int n) {
    StringBuilder str = new StringBuilder();
    str.append(n).append(" ");
    for(int i = 1; i < n; i++) {
      str.append(i).append(" ");
    }
    str.deleteCharAt(str.length()-1);
    return str.toString();
  }
}
