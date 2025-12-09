import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int y = sc.nextInt();
      int r = sc.nextInt();
      int ans = r;
      n -= r;
      y = y/2;
      ans += Math.min(y, n);
      System.out.println(ans);
    }
    sc.close();
  }
}
