import java.util.*;

public class Flowers {
    
    static final int mod = 1000000007;
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        int K = sc.nextInt();
        
        int[][] arr = new int[T][2];
        int max = 0;
        
        for(int i = 0; i < T; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            
            max = Math.max(max, arr[i][1]);
        }
        
        int[] ans = solve(K, max);
        
        for(int i = 0; i < T; i++) {
            System.out.println((ans[arr[i][1]]-ans[arr[i][0]-1]+mod)%mod);
        }
    }
    
    public static int[] solve(int k, int n) {
        int[] ans = new int[n+1];
        ans[0] = 1;//base case
        
        for(int i = 1; i <= n; i++) {
            ans[i] = (ans[i] + ans[i-1]) % mod;
            if(i-k >= 0) {
                ans[i] = (ans[i] + ans[i-k]) % mod;
            }
        }
        
        for(int i = 1; i <= n; i++) {
            ans[i] = (ans[i] + ans[i-1]) % mod;
        }
        
        return ans;
    }
}
