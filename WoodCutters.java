import java.util.*;

public class WoodCutters {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[][] arr = new int[n][2];
        
        for(int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
    
        System.out.println(solve(arr, n));
    }
    
    public static int solve(int[][] arr, int n) {
        
        dp = new Integer[n][3];
        
        return maxTree(arr, 0, 0);
    }
    
    static Integer[][] dp;
    
    public static int maxTree(int[][] arr, int i, int state) {
        if(i == arr.length) {
            return 0;
        }
        
        if(dp[i][state] != null) {
            return dp[i][state];
        }
        
        int ans = 0;
        
        if(state == 0 || state == 1) {
            if(i == 0 || (arr[i][0]-arr[i][1]) > arr[i-1][0]) {
                int curr = maxTree(arr, i+1, 1);
                ans = Math.max(ans, curr);
            }
            if(i == arr.length-1 || (arr[i][0]+arr[i][1]) < arr[i+1][0]) {
                int curr = maxTree(arr, i+1, 2);
                ans = Math.max(ans, curr);
            }
        }
        else {
            if(i == 0 || (arr[i][0]-arr[i][1]) > (arr[i-1][0]+arr[i-1][1])) {
                int curr = maxTree(arr, i+1, 1);
                ans = Math.max(ans, curr);
            }
            if(i == arr.length-1 || (arr[i][0]+arr[i][1]) < arr[i+1][0]) {
                int curr = maxTree(arr, i+1, 2);
                ans = Math.max(ans, curr);
            }
        }
        
        int skip = maxTree(arr, i+1, 0);
        
        return dp[i][state] = Math.max(ans+1, skip);
    }
}
