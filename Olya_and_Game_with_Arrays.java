import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int n = sc.nextInt();
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[1]-a[1]);
      for(int i = 0; i < n; i++) {
        int m = sc.nextInt();
        int[] arr = new int[m];
        for(int j = 0; j < m; j++) {
          arr[j] = sc.nextInt();
        }
        Arrays.sort(arr);
        pq.add(arr);
      }
      System.out.println(solve(n, pq));
    }
    sc.close();
  }
  public static long solve(int n, PriorityQueue<int[]> pq) {
    if(n == 1) {
      return pq.peek()[0];
    }
    long ans = 0;
    int min = Integer.MAX_VALUE;
    while(pq.size() > 1) {
      ans += pq.peek()[1];
      min = Math.min(min, pq.poll()[0]);
    }
    min = Math.min(pq.poll()[0], min);
    ans += min;
    return ans;
  }
}
