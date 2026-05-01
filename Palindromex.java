import java.util.*;

public class Palindromex {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
    
            int[] arr = new int[2*n];
            int idx1 = -1;
            int idx2 = -1;
            
            for (int i = 0; i < 2*n; i++) {
                
                arr[i] = sc.nextInt();
                
                if (arr[i] == 0) {
                    idx2 = idx1;
                    idx1 = i;
                }
            }
            
            int ans = 0;
            
            ans = Math.max(ans, solve(idx1, idx1, arr));
            ans = Math.max(ans, solve(idx2, idx2, arr));
            ans = Math.max(ans, solve((idx1+idx2)/2, (idx1+idx2+1)/2, arr));
            
            out.append(ans).append('\n');
        }
        
        System.out.print(out);
    }
    
    public static int solve(int i, int j, int[] arr) {
        
        HashSet<Integer> set = new HashSet<>();
        
        while (i >= 0 && j < arr.length && arr[i] == arr[j]) {
            set.add(arr[i]);
            i--;
            j++;
        }
        
        int x = 0;
        
        while(set.contains(x)) {
            x++;
        }
        
        return x;
    }
}
