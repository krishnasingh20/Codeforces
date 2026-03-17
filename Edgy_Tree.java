import java.util.*;

public class Edgy_Tree {
    
    static class DSU {
        int[] parent;
        int[] size;
        int n;
        
        public DSU(int n) {
            this.n = n;
            parent = new int[n+1];
            size = new int[n+1];
            
            for(int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        int find(int node) {
            if(node == parent[node]) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }
        
        void union(int a, int b) {
            int p1 = find(a);
            int p2 = find(b);
            
            if(p1 == p2) {
                return;
            }
            
            if(size[p1] > size[p2]) {
                parent[p2] = p1;
                size[p1] += size[p2];
            }
            else {
                parent[p1] = p2;
                size[p2] += size[p1];
            }
        }
    }
    
    static final int mod = 1000000007;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[][] edges = new int[n-1][3];
        
        for(int i = 0; i < n-1; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        
        System.out.println(solve(n, k, edges));
    }
    
    public static int solve(int n, int k, int[][] edges) {
        
        DSU dsu = new DSU(n);
        
        for(int i = 0; i < n-1; i++) {
            if(edges[i][2] == 1) {
                continue;
            }
            
            dsu.union(edges[i][0], edges[i][1]);
        }
        
        HashSet<Integer> parent = new HashSet<>();
        
        for(int i = 1; i <= n; i++) {
            int p = dsu.find(i);
            parent.add(p);
        }
        
        long notGood = 0;
        
        for(int p: parent) {
            notGood = (notGood + power((long)dsu.size[p], k)) % mod;
        }
        
        long total = power((long)n, k);
        
        return (int)((total - notGood + mod) % mod);
    }
    
    private static long power(long a, int b) {
        if(b == 0) {
            return 1;
        }
        
        long ans = power(a, b/2);
        ans = (ans * ans) % mod;
        
        if((b & 1) == 1) {
            ans = (ans * a) % mod;
        }
        
        return ans;
    }
}
