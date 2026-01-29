import java.util.*;
public class Divisible_Permutation {
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
    int[] arr = new int[n];
    int i = 1;
    int j = n;
    int c = 0;
    int idx = n-1;
    while(c < n-1) {
      arr[idx--] = i;
      arr[idx--] = j;
      i++;
      j--;
      c += 2;
    }
    if((n & 1) == 1) {
      arr[idx] = i;
    }
    StringBuilder sb = new StringBuilder();
    for(i = 0; i < n; i++) {
      sb.append(arr[i]).append(" ");
    }
    return sb.toString();
  }
}
