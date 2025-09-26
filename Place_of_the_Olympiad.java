import java.util.*;

public class Place_of_the_Olympiad {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      long n = sc.nextLong();
      long m = sc.nextLong();
      long k = sc.nextLong();
      System.out.println(solve(n, m, k));
    }
    sc.close();
  }
  public static long solve(long n, long m, long k) {
    long low = 1;
    long high = m;
    long ans = 0;
    while(low <= high) {
      long mid = low + (high - low)/2;
      long c = m/(mid+1);
      c = c*mid + (m%(mid+1));
      long val = c*n;
      if(val >= k) {
        ans = mid;
        high = mid - 1;
      }
      else {
        low = mid + 1;
      }
    }
    return ans;
  }
}
