import java.util.Scanner;
public class Bitwise_XOR {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Bitwise_XOR obj = new Bitwise_XOR();
    int t = sc.nextInt();
    while(t-- > 0) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.println(obj.solve(a, b));
    }
    sc.close();
  }
  private String solve(int a, int b) {
    if(a == b) {
      return "0";
    }
    int len = 32 - Integer.numberOfLeadingZeros(a);
    int a1 = (1<<len)-1;
    if(a1 < b) {
      return "-1";
    }
    StringBuilder sb = new StringBuilder();
    int c = 0;
    int i = 0;
    while(b > 0) {
      if((b & 1) == 1) {
        if((a & 1) != 1) {
          sb.append((1<<i)).append(" ");
          c++;
        }
      }
      else {
        if((a & 1) == 1) {
          sb.append((1<<i)).append(" ");
          c++;
        }
      }
      b >>= 1;
      a >>= 1;
      i++;
    }
    while(a > 0) {
      if((a & 1) == 1) {
        sb.append((1<<i)).append(" ");
        c++;
      }
      a >>= 1;
      i++;
    }
    System.out.println(c);
    return sb.toString();
  }
}
