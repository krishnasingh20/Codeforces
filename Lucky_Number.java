import java.util.Scanner;
public class Lucky_Number {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    // int T = 1;
    while(T-- > 0) {
      long n = sc.nextLong();
      System.out.println(solve(n));
    }
    sc.close();
  }
  public static String solve(long n) {
    long num = n;
    int c = 0;
    while(num > 0) {
      c++;
      num /= 10;
    }
    return permu(0, c, 0, n)?"YES":"NO";
  }
  public static boolean permu(int i, int c, long num, long n) {
    if(i <= c) {
      if(num > 0 && n % num == 0) {
        return true;
      }
      if(i == c) {
        return false;
      }
    }
    if(permu(i+1, c, (num*10)+4, n)) {
      return true;
    }
    if(permu(i+1, c, (num*10)+7, n)) {
      return true;
    }
    return false;
  }
}
