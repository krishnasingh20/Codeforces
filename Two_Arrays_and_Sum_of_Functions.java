import java.util.*;

public class Two_Arrays_and_Sum_of_Functions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        System.out.println(solve(n, a, b));
    }
    
    public static long solve(int n, int[] a, int[] b) {
        long MOD = 998244353;
        long[] arr = new long[n];
        for(int i = 0; i < n; i++) {
            long curr = ((long)(i+1)*(n-i)*a[i]);
            arr[i] = curr;
        }
        
        Arrays.sort(arr);
        Arrays.sort(b);
        
        long ans = 0;
        int k = n-1;
        
        for(int i = 0; i < n; i++) {
            ans = (ans + (arr[i] % MOD)*b[k--]) % MOD;
        }
        
        return ans % MOD;
    }
}
