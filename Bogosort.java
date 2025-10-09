import java.util.*;

public class Main {
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
    Arrays.sort(arr);
    int i = 0;
    int j = n - 1;
    while(i < j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
    StringBuilder sb = new StringBuilder();
    for(i = 0; i < n; i++) {
      sb.append(arr[i]).append(" ");
    }
    sb.deleteCharAt(sb.length()-1);
    return sb.toString();
  }
}
