import java.util.*;

public class Cyclists {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        // int T = 1;
        while(T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int p = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(solve(n, k, p, m, arr));
        }
        
        sc.close();
    }
    
    public static int solve(int n, int k, int p, int m, int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> q = new LinkedList<>();

        arr[p-1] = -arr[p-1];
        for(int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for(int i = k; i < n; i++) {
            q.add(arr[i]);
        }

        int ans = 0;

        while(m > 0) {

            int x = pq.poll();
            if(m - Math.abs(x) < 0) {
                break;
            }

            m -= Math.abs(x);
            if(x < 0) {
                ans++;
            }

            q.add(x);
            x = q.poll();
            pq.add(x);
        }

        return ans;
    }
}
