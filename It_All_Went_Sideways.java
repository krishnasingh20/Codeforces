import java.util.*;

public class It_All_Went_Sideways {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
    
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            out.append(solve(n, arr)).append('\n');
        }
        
        System.out.print(out);
    }
    
    public static long solve(int n, int[] arr) {
        
        Stack<Integer> st = new Stack<>();
        long ans = 0;
        
        for (int i = 0; i < n; i++) {
            
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                ans = Math.max(ans, i);
            }
            else {
                ans = Math.max(ans, i-st.peek()-1);
            }
            
            st.push(i);
        }
        
        int min  = arr[n-1];
        
        for(int i = n - 1; i >= 0; i--) {
            ans += Math.max(0, arr[i]-min);
            min = Math.min(min, arr[i]);
        }
        
        return ans;
    }
}
