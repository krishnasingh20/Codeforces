import java.util.*;
public class The_Robotic_Rush {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      a = new int[n];
      b = new int[m];
      for(int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      for(int i = 0; i < m; i++) {
        b[i] = sc.nextInt();
      }
      String s = sc.next();
      char[] ch = s.toCharArray();
      System.out.println(solve(n, m, k, ch));
    }
    sc.close();
  }
  static int[] a;
  static int[] b;
  public static String solve(int n, int m, int k, char[] ch) {
    Arrays.sort(b);
    HashMap<Integer, Integer> map = new HashMap<>();
    int prefix = 0;
    for(int i = 0; i < k; i++) {
      prefix += (ch[i]=='L'?-1:1);
      map.putIfAbsent(prefix, i);
    }
    int[] ans = new int[k];
    for(int i = 0; i < n; i++) {
      int idx1 = lowerBound(a[i]);
      int idx2 = upperBound(a[i]);
      int idx = Integer.MAX_VALUE;
      if(idx1 != -1) {
        int diff = b[idx1] - a[i];
        if(map.containsKey(diff)) {
          idx = Math.min(idx, map.get(diff));
        }
      }
      if(idx2 != -1) {
        int diff = b[idx2] - a[i];
        if(map.containsKey(diff)) {
          idx = Math.min(idx, map.get(diff));
        }
      }
      if(idx != Integer.MAX_VALUE) {
        ans[idx]++;
      }
    }
    int Alive = n;
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < k; i++) {
      Alive -= ans[i];
      sb.append(Alive).append(" ");
    }
    return sb.toString();
  }
  public static int lowerBound(int target) {
    int idx = -1;
    int low = 0;
    int high = b.length-1;
    while(low <= high) {
      int mid = low + (high-low)/2;
      if(b[mid] <= target) {
        idx = mid;
        low = mid + 1;
      }
      else {
        high = mid - 1;
      }
    }
    return idx;
  }
  public static int upperBound(int target) {
    int idx = -1;
    int low = 0;
    int high = b.length-1;
    while(low <= high) {
      int mid = low + (high-low)/2;
      if(b[mid] >= target) {
        idx = mid;
        high = mid - 1;
      }
      else {
        low = mid + 1;
      }
    }
    return idx;
  }
}
