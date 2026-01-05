import java.util.*;
public class Battle_of_Arrays {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[m];
      for(int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      for(int i = 0; i < m; i++) {
        b[i] = sc.nextInt();
      }
      System.out.println(solve(n, m, a, b));
    }
    sc.close();
  }
  public static String solve(int n, int m, int[] a, int[] b) {
    PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
    for(int i = 0; i < n; i++) {
      pq1.add(a[i]);
    }
    for(int i = 0; i < m; i++) {
      pq2.add(b[i]);
    }
    boolean flag = true;
    while(!pq1.isEmpty() && !pq2.isEmpty()) {
      if(flag) {
        int x = pq1.peek();
        int y = pq2.poll();
        if(x < y) {
          pq2.add(y-x);
        }
        flag = !flag;
      }
      else {
        int x = pq1.poll();
        int y = pq2.peek();
        if(x > y) {
          pq1.add(x-y);
        }
        flag = !flag;
      }
    }
    if(pq1.isEmpty()) {
      return "Bob";
    }
    return "Alice";
  }
}
