import java.util.*;
public class Meximum_Array_2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int q = sc.nextInt();
      int[][] query = new int[q][3];
      for(int i = 0; i < q; i++) {
        query[i][0] = sc.nextInt();
        query[i][1] = sc.nextInt();
        query[i][2] = sc.nextInt();
      }
      System.out.println(solve(n, k, q, query));
    }
    sc.close();
  }
  public static String solve(int n, int k, int q, int[][] query) {
    int[] arr = new int[n];
    for(int i = 0; i < q; i++) {
      int l = query[i][1]-1;
      int r = query[i][2]-1;
      if(query[i][0] == 1) {
        for(int j = l; j <= r; j++) {
          arr[j] = k;
        }
      }
    }
    for(int i = 0; i < q; i++) {
      int l = query[i][1]-1;
      int r = query[i][2]-1;
      int curr = 0;
      if(query[i][0] == 2) {
        for(int j = l; j <= r; j++) {
          if(arr[j] > k) {
            continue;
          }
          if(arr[j] == k) {
            arr[j]++;
            continue;
          }
          arr[j] = (j+1)%k;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++) {
      sb.append(arr[i]).append(" ");
    }
    return sb.toString();
  }
}
