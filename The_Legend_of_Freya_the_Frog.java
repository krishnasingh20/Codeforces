import java.util.*;
 
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      int k = sc.nextInt();
      System.out.println(solve(x, y, k));
    }
    sc.close();
  }
  public static int solve(int x, int y, int k) {
    int a = (x+k-1)/k;//taking ceil of at least a step or jump required to go x
    int b = (y+k-1)/k;//taking ceil of at least b step or jump required to go y
    int ans = Math.max(a, b)*2;
    if(a > b) {
      return ans-1;
    }
    return ans;
  }
}
