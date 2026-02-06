import java.util.*;
public class Fight_with_Monsters {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long a = sc.nextLong();
    long b = sc.nextLong();
    long k = sc.nextLong();
    long[] arr = new long[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextLong();
    }
    System.out.println(solve(n, a, b, k, arr));
  }
  public static int solve(int n, long a, long b, long k, long[] arr) {
    int ans = 0;
    List<Long> ll = new ArrayList<>();
    for(int i = 0; i < n; i++) {
      long rem = arr[i] % (a + b);
      if(rem == 0) {
        rem = a+b;
      }
      if(rem <= a) {
        ans++;
      }
      else {
        long opr = (rem - 1)/a;
        ll.add(opr);
      }
    }
    Collections.sort(ll);
    long curr = 0;
    int idx = -1;
    for(int i = 0; i < ll.size(); i++) {
      curr += ll.get(i);
      if(curr > k) {
        break;
      }
      idx = i;
    }
    ans += idx+1;
    return ans;
  }
}
