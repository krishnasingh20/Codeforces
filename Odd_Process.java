import java.util.*;
public class Odd_Process {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(solve(n, arr));
    }
    sc.close();
  }
  public static String solve(int n, int[] arr) {
    StringBuilder sb = new StringBuilder();
    Arrays.sort(arr);
    int odd = 0;
    int even = 0;
    for(int i = 0; i < n; i++) {
      if((arr[i] & 1) == 1) {
        odd++;
      }
      else {
        even++;
      }
    }
    long[] suffixEven = new long[even+1];
    long[] suffixOdd = new long[odd+1];
    int idx1 = 0;
    int idx2 = 0;
    for(int i = 0; i < n; i++) {
      if((arr[i] & 1) == 1) {
        suffixOdd[idx1++] = arr[i];
      }
      else {
        suffixEven[idx2++] = arr[i];
      }
    }
    for(int i = odd-1; i >= 0; i--) {
      suffixOdd[i] += suffixOdd[i+1];
    }
    for(int i = even - 1; i >= 0; i--) {
      suffixEven[i] += suffixEven[i+1];
    }
    for(int k = 1; k <= n; k++) {
      if(even == 0) {
        if((k&1) == 1) {
          sb.append(arr[n-1]).append(" ");
        }
        else {
          sb.append(0).append(" ");
        }
      }
      else if(odd == 0) {
        sb.append(0).append(" ");
      }
      else {
        long ans = 0;
        if(even < k-1) {
          if(((k-even) & 1) == 0) {
            if(odd > k-even) {
              ans += suffixEven[1];
              ans += suffixOdd[odd-1];
            }
          }
          else {
            ans += suffixEven[0];
            ans += suffixOdd[odd-1];
          }
        }
        else {
          ans += suffixEven[even-(k-1)];
          ans += suffixOdd[odd-1];
        }
        sb.append(ans).append(" ");
      }
    }
    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
  }
}
