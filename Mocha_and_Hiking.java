import java.util.*;
public class Mocha_and_Hiking {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int[] arr = new int[n+1];
      for(int i = 1; i <= n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(solve(n, arr));
    }
    sc.close();
  }
  public static String solve(int n, int[] arr) {
    StringBuilder sb = new StringBuilder();
    if(arr[n] == 0) {
      for(int i = 1; i <= n+1; i++) {
        sb.append(i).append(" ");
      }
      return sb.toString();
    }
    int idx = -1;
    for(int i = 1; i <= n; i++) {
      if(arr[i] == 1 && arr[i-1] == 0) {
        idx = i;
        break;
      }
    }
    if(idx == -1) {
      return "-1";
    }
    for(int i = 1; i < idx; i++) {
      sb.append(i).append(" ");
    }
    sb.append((n+1)).append(" ");
    for(int i = idx; i <= n; i++) {
      sb.append(i).append(" ");
    }
    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
  }
}
