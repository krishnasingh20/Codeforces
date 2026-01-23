import java.util.*;
public class Table_with_Numbers {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int h = sc.nextInt();
      int l = sc.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(solve(n, h, l, arr));
    }
    sc.close();
  }
  public static int solve(int n, int h, int l, int[] arr) {
    Arrays.sort(arr);
    int ans = 0;
    int temp = Math.min(h, l);
    l = Math.max(h, l);
    h = temp;
    int idx1 = -1;
    int idx2 = -1;
    for(int i = 0; i < n; i++) {
      if(arr[i] > h) {
        break;
      }
      idx1 = i;
    }
    for(int i = 0; i < n; i++) {
      if(arr[i] > l) {
        break;
      }
      idx2 = i;
    }
    if(idx1 == -1 || idx2 == -1) {
      return 0;
    }
    int i = 0;
    int j = idx2;
    while(i < j && i <= idx1) {
      ans++;
      i++;
      j--;
    }
    return ans;
  }
}
