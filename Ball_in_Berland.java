import java.util.*;
public class Ball_in_Berland {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int k = sc.nextInt();
      graph = new int[k][2];
      for(int i = 0; i < k; i++) {
        graph[i][0] = sc.nextInt();
      }
      for(int i = 0; i < k; i++) {
        graph[i][1] = sc.nextInt();
      }
      System.out.println(solve(a, b, k));
    }
    sc.close();
  }
  static int[][] graph;
  public static long solve(int a, int b, int k) {
    int[] outDegree = new int[a+1];
    int[] inDegree = new int[b+1];
    for(int i = 0; i < k; i++) {
      inDegree[graph[i][1]]++;
      outDegree[graph[i][0]]++;
    }
    long ans = 0;
    for(int i = 0; i < k; i++) {
      long curr = inDegree[graph[i][1]];
      curr += outDegree[graph[i][0]] - 1;
      ans += (k - curr);
    }
    return ans/2;
  }
}
