import java.util.*;
public class Dorm_Water_Supply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        
        int[] inDegree = new int[n+1];
        List<List<int[]>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < p; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            
            inDegree[b]++;
            adj.get(a).add(new int[]{b, d});
        }
        
        List<int[]> ans = solve(n, inDegree, adj);
        
        System.out.println(ans.size());
        
        for(int[] a: ans) {
            System.out.println(a[0]+" "+a[1]+" "+a[2]);
        }
    }
    
    public static List<int[]> solve(int n, int[] inDegree, List<List<int[]>> adj) {
        
        List<int[]> ans = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            if(inDegree[i] == 0) {
                d1 = Integer.MAX_VALUE;
                des = -1;
                
                dfs(i, adj);
                
                if(i != des) {
                    ans.add(new int[]{i, des, d1});
                }
            }
        }
        
        Collections.sort(ans, (a, b)->Integer.compare(a[0], b[0]));
        
        return ans;
    }
    
    static int d1;
    static int des;
    
    static void dfs(int src, List<List<int[]>> adj) {
        des = src;
        for(int[] nbrs: adj.get(src)) {
            d1 = Math.min(d1, nbrs[1]);
            dfs(nbrs[0], adj);
        }
    }
}
