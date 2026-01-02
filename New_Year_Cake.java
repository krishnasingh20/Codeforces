import java.util.*;
public class New_Year_Cake {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.println(solve(a, b));
    }
    sc.close();
  }
  public static int solve(int a, int b) {
    // case-1->when white is at top
    int a1 = a;
    int b1 = b;
    int ans = 0;
    int l = 0;
    int c1 = 0;
    int c2 = 1;
    boolean flag = true;
    while((flag && a1 >= (int)Math.pow(2, c1)) || (!flag && b1 >= (int)Math.pow(2, c2))) {
      if(flag) {
        a1 -= (int)Math.pow(2, c1);
        c1 += 2;
      }
      else {
        b1 -= (int)Math.pow(2, c2);
        c2 += 2;
      }
      l++;
      flag = !flag;
    }
    ans = Math.max(ans, l);
    // case-2->when dark is at top
    a1 = a;
    b1 = b;
    l = 0;
    c1 = 1;
    c2 = 0;
    flag = false;
    while((!flag && b1 >= (int)Math.pow(2, c2)) || (flag && a1 >= (int)Math.pow(2, c1))) {
      if(flag) {
        a1 -= (int)Math.pow(2, c1);
        c1 += 2;
      }
      else {
        b1 -= (int)Math.pow(2, c2);
        c2 += 2;
      }
      l++;
      flag = !flag;
    }
    ans = Math.max(ans, l);
    return ans;
  }
}
