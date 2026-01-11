import java.util.*;
public class Two_Buttons {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    System.out.println(bfs(n, m));
  }
  public static int bfs(int n, int m) {
    int step = 0;
    boolean[] visited = new boolean[20001];
    Queue<Integer> q = new LinkedList<>();
    q.add(n);
    visited[n] = true;
    while(!q.isEmpty()) {
      int size =q.size();
      while(size-- > 0) {
        int rv = q.poll();
        if(rv == m) {
          return step;
        }
        int red = rv*2;
        if(red <= 20000 && !visited[red]) {
          visited[red] = true;
          q.add(red);
        }
        int blue = rv-1;
        if(blue >= 1 && !visited[blue]) {
          visited[blue] = true;
          q.add(blue);
        }
      }
      step++;
    }
    return -1;
  }
}
