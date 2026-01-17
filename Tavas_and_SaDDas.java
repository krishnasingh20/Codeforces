import java.util.*;
public class Tavas_and_SaDDas {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    System.out.println(solve(s));
  }
  public static long solve(String s) {
    int n = s.length();
    long count = (1 << n) - 2;//count of all lucky number less the n length number
    int pos = 0;
    for(int i = n-1; i >= 0; i--) {
      if(s.charAt(i) == '7') {//we can change it to 4 and calculate how many smaller numer it will form
        count += (1<<pos);
      }
      pos++;
    }
    return count+1;//1 addition for current number index
  }
}
