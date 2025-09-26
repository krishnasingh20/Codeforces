import java.util.*;
 
public class Be_Positive {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      long[] arr = new long[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
      }
      System.out.println(solve(n, arr));
    }
    sc.close();
  }
  public static long solve(int n, long[] arr) {
    int zero = 0;
    int neg = 0;
    for(long num: arr) {
      if(num == 0) {
        zero++;
      }
      else if(num == -1) {
        neg++;
      }
    }
    long ans = zero+ (2*(neg%2));
    return ans;
  }
  
}
