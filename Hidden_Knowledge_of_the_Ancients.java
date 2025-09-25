import java.util.*;
 
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int l = sc.nextInt();
      int r = sc.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      System.out.println(solve(n, k, l, r, arr));
    }
    sc.close();
  }
  public static long solve(int n, int k, int l, int r, int[] arr) {
    long a = count(n, k, l, r, arr);
    long b = count(n, k-1, l, r, arr);
    return a - b;
  }
  public static long count(int n, int k, int l, int r, int[] arr) {
    long ans = 0;
    int ei = 0;
    int si = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    int dist = 0;
    while(ei < n) {
      if(map.getOrDefault(arr[ei], 0) == 0) {
        dist++;
      }
      map.put(arr[ei], map.getOrDefault(arr[ei], 0) + 1);
      while(dist > k) {
        map.put(arr[si], map.get(arr[si])-1);
        if(map.get(arr[si]) == 0) {
          dist--;
        }
        si++;
      }
      int len = ei - si + 1;
      int start = Math.max(si, ei - r + 1);
      int end = ei - l + 1;
      if(end >= start) {
        ans += (end - start + 1);
      }
      ei++;
    }
    return ans;
  }
}
