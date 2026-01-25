import java.util.*;
public class Product_Queries {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
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
    HashSet<Integer> set = new HashSet<>();
    for(int i = 0; i < n; i++) {
      set.add(arr[i]);
    }
    int[] a = new int[set.size()];
    int idx = 0;
    for(int s: set) {
      a[idx++] = s;
    }
    Arrays.sort(a);
    int[] dist = new int[n+1];
    Arrays.fill(dist, -1);
    Queue<Integer> q = new LinkedList<>();
    for(int i: a) {
      dist[i] = 1;
      if(i != 1) {
        q.add(i);
      }
    }
    while(!q.isEmpty()) {
      int rv = q.poll();
      for(int i: a) {
        long curr = (long)i*rv;
        if(curr > n) {
          break;
        }
        if(dist[(int)curr] == -1) {
          dist[(int)curr] = dist[rv]+1;
          q.add((int)curr);
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int i = 1; i <= n; i++) {
      sb.append(dist[i]).append(" ");
    }
    return sb.toString();
  }
}
