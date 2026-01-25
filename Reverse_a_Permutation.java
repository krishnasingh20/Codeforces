import java.util.*;
public class Reverse_a_Permutation {
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
  }
  public static String solve(int n, int[] arr) {
    int idx = -1;
    int x = n;
    for(int i = 0; i < n; i++) {
      if(arr[i] != x) {
        idx = i;
        break;
      }
      x--;
    }
    StringBuilder sb = new StringBuilder();
    if(idx == -1) {
      for(int i = 0; i < n; i++) {
        sb.append(arr[i]).append(" ");
      }
      return sb.toString();
    }
    int idx1 = -1;
    for(int i = idx; i < n; i++) {
      if(arr[i] == x) {
        idx1 = i;
        break;
      }
    }
    reverse(arr, idx, idx1);
    for(int i = 0; i < n; i++) {
      sb.append(arr[i]).append(" ");
    }
    return sb.toString();
  }
  public static void reverse(int[] arr, int i, int j) {
    while(i < j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }
}
