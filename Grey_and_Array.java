import java.util.*;

public class Grey_and_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        // t = sc.nextInt();
        while(t-- > 0) {
            solve(sc);
        }
    }

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        long[] arr = new long[n+1];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        int[][] query = new int[m][3];

        for(int i = 0; i < m; i++) {
            query[i][0] = sc.nextInt();
            query[i][1] = sc.nextInt();
            query[i][2] = sc.nextInt();
        }

        int[] opr = new int[m+1];

        for(int i = 0; i < k; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            l--;
            opr[l]++;
            opr[r]--;
        }

        for(int i = 1; i <= m; i++) {
            opr[i] += opr[i-1];
        }

        long[] diff = new long[n+1];

        for(int i = 0; i < m; i++) {
            int l = query[i][0] - 1;
            int r = query[i][1];
            int d = query[i][2];
            long total = (long)d * opr[i];
            diff[l] += total;
            diff[r] -= total; 
        }

        for(int i = 1; i <= n; i++) {
            diff[i] += diff[i-1];
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            sb.append(arr[i]+diff[i]).append(' ');
        }

        System.out.println(sb);
    }
}
