import java.util.*;
public class XOR_Convenience_Easy_Version {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      System.out.println(solve(n));
    }
    sc.close();
  }
  public static String solve(int n) {
    StringBuilder sb = new StringBuilder();
    int[] arr = new int[n];
    arr[n-1] = 1;
    long sum1 = 0;
    long sum2 = 0;
    for(int i = 1; i < n - 1; i++) {
      arr[i] = (i+1)^1;
      sum1 += (i+1);
      sum2 += arr[i];
    }
    sum1 += 1 + n;;
    sum2 += 1;
    sb.append(sum1 - sum2).append(" ");
    for(int i = 1; i < n; i++) {
      sb.append(arr[i]).append(" ");
    }
    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
  }
}
