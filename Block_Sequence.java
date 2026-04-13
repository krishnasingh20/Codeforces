import java.util.*;

public class Block_Sequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder out = new StringBuilder();

        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            out.append(bottomUp(n, arr)).append('\n');
        }

        System.out.print(out);

        sc.close();
    }

    public static int bottomUp(int n, int[] arr) {
        int[] dp = new int[n+1];

        for(int i = n-1; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;

            if(arr[i]+i < n) {
                int opr = dp[arr[i]+i+1];
                ans = Math.min(ans, opr);
            }

            int opr = 1 + dp[i+1];
            ans = Math.min(ans, opr);

            dp[i] = ans;
        }

        return dp[0];
    } 

}
