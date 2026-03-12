import java.util.*;
public class Maximize_the_root {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            int[] value = new int[n+1];
            for(int i = 1; i <= n; i++) {
                value[i] = sc.nextInt();
            }
            List<Integer>[] tree = new ArrayList[n+1];
            for(int i = 1; i <= n; i++) {
                tree[i] = new ArrayList<>();
            }
            for(int i = 2; i <= n; i++) {
                int p = sc.nextInt();
                tree[p].add(i); 
            }
            System.out.println(dfs(tree, value, 1));
        }
        sc.close();
    }
    public static int dfs(List<Integer>[] tree, int[] value, int src) {
        int curr = Integer.MAX_VALUE;
        for(int child: tree[src]) {
            curr = Math.min(curr, dfs(tree, value, child));
        }
        if(src == 1) {
            if(curr != Integer.MAX_VALUE) {
                value[src] += curr;
            }
            return value[src];
        }
        else {
            if(curr != Integer.MAX_VALUE) {
                if(curr <= value[src]) {
                    return curr;
                }
                else {
                    int c = curr - value[src];
                    return value[src]+(c/2);
                }
            }
            else {
                return value[src];
            }
        }
    }
}
