import java.util.Scanner;
public class New_Year_String {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      String s = sc.next();
      System.out.println(solve(n, s));
    }
    sc.close();
  }
  public static int solve(int n, String s) {
    int c = 0;
    char[] ch = s.toCharArray();
    boolean flag = false;
    for(int i = 0; i < n-3; i++) {
      if(ch[i] == '2' && ch[i+1] == '0' && ch[i+2] == '2') {
        if(ch[i+3] == '5') {
          c++;
        }
        else if(ch[i+3] == '6') {
          flag = true;
        }
      }
    }
    if(flag || c == 0) {
      return 0;
    }
    return 1;
  }
}
