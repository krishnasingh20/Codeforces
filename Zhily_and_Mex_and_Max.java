import java.util.*;

public class Zhily_and_Mex_and_Max {
    
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
    
    public static long solve(int n, int[] arr) {
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            set.add(arr[i]);
        }
        long ans = max == 0 ? 1 : max;
        int curr = 0;
        int i = 1;
        while(i < n) {
            if(max != curr && !set.contains(curr)) {
                ans += (max+curr);
                i++;
                continue;
            }
            if(max == curr) {
                curr++;
                if(set.contains(curr)) {
                    curr++;
                }
            }
            else if(set.contains(curr)) {
                curr++;
                if(max == curr) {
                    curr++;
                }
            }
            ans += max + curr;
            i++;
        }
        
        return ans;
    }
}
