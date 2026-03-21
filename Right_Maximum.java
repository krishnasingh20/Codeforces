import java.util.*;

public class Right_Maximum {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        while(T-- > 0) {
            int n = sc.nextInt();
            
            int[] arr = new int[n];
            
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            System.out.println(solve(n, arr));
        }
    }
    
    public static int solve(int n, int[] arr) {
        int[] max = new int[n];
        max[0] = arr[0];
        
        for(int i = 1; i < n; i++) {
            max[i] = Math.max(max[i-1], arr[i]);
        }
        
        int ans = 0;
        
        for(int i = n-1; i >= 0; i--) {
            if(arr[i] == max[i]) {
                ans++;
            }
        }
        
        return ans;
    }
}
