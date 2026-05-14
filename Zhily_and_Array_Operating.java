import java.util.*;

public class Zhily_and_Array_Operating {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        
        int T = sc.nextInt();
        
        while(T-- > 0)  {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            out.append(solve(n, arr)).append('\n');
        }
        
        System.out.print(out);
    }
    
    public static int solve(int n, int[] arr) {
        int ans = arr[n-1] > 0 ? 1 : 0;
        long curr = arr[n-1];
        for(int i = n - 2; i >= 0; i--) {
            curr = Math.max(arr[i], curr + arr[i]);
            if(curr > 0) {
                ans++;
            }
        }
        return ans;
    }
}
