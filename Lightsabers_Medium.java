import java.util.*;

public class Lightsabers_Medium {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int[] color = new int[m+1];
        int cnt = 0;
        int t = 0;
        
        for(int i = 1; i <= m; i++) {
            color[i] = sc.nextInt();
            t += color[i];
            if(color[i] == 0) {
                cnt++;
            }
        }
        
        int[] curr = new int[m+1];
        
        int ans = Integer.MAX_VALUE;
        int si = 0;
        int ei = 0;
        
        while(ei < n) {
            curr[arr[ei]]++;
            
            if(curr[arr[ei] ]== color[arr[ei]]) {
                cnt++;
            }
            
            while(cnt == m) {
                ans = Math.min(ans, (ei-si+1));
                
                if(--curr[arr[si]] < color[arr[si]]) {
                    cnt--;
                }
                
                si++;
            }
            
            ei++;
        }
        
        System.out.println(ans == Integer.MAX_VALUE?-1:(ans - t));
    }
}
