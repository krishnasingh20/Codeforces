import java.util.Arrays;
import java.util.Scanner;

public class Path_Queries {

    static class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n+1];
            size = new int[n+1];
            for(int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int v) {
            if(v == parent[v]) {
                return v;
            }
            return parent[v] = findParent(parent[v]);//path compression
        }

        long unionBySize(int u, int v) {
            int p1 = findParent(u);
            int p2 = findParent(v);

            if(p1 == p2) {
                return 0;
            }

            long count = (long)size[p1] * size[p2];

            if(size[p1] > size[p2]) {
                parent[p2] = p1;
                size[p1] += size[p2];
            }
            else {
                parent[p1] = p2;
                size[p2] += size[p1];
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[][] edges = new int[n-1][3];

        for(int i = 0; i < n-1; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }


        int[] query = new int[q];

        for(int i = 0; i < q; i++) {
            query[i] = sc.nextInt();
        }

        long[] ans = solve(n, edges, q, query);

        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public static long[] solve(int n, int[][] edges, int q, int[] query) {
        DSU dsu = new DSU(n);

        Arrays.sort(edges, (a, b)->a[2]-b[2]);
        int[][] arr = new int[q][2];

        for(int i = 0; i < q; i++) {
            arr[i][0] = query[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b)->a[0]-b[0]);

        long[] ans = new long[q];

        int j = 0;
        long curr = 0;

        for(int i = 0; i < q; i++) {
            while(j < n-1 && edges[j][2] <= arr[i][0]) {
                curr += dsu.unionBySize(edges[j][0], edges[j][1]);
                j++;
            }
            ans[arr[i][1]] = curr;
        }

        return ans;
    }
}
