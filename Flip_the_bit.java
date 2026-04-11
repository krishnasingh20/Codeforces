import java.util.*;
 
public class Flip_the_bit {
    
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
 
            int[] arr = new int[n];
 
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
 
            int idx = sc.nextInt() - 1;
 
            System.out.println(solve(n, idx, arr));
        }
    }
 
    public static int solve(int n, int idx, int[] arr) {
        int i = 0;
        while(i < idx && arr[i] == arr[idx]) {
            i++;
        }
        
        int j = n-1;
        while(j > idx && arr[j] == arr[idx]) {
            j--;
        }
        
        int prev1 = -1;
        int cnt1 = 0;
        int idx1 = i;
        
        for(; i < idx; i++) {
            if(prev1 == -1) {
                cnt1++;
                prev1 = arr[i];
            }
            else {
                if(arr[i] != prev1) {
                    prev1 = arr[i];
                    cnt1++;
                }
            }
        }
        
        int prev2 = -1;
        int cnt2 = 0;
        int idx2 = j;
        
        for(; j > idx; j--) {
            if(prev2 == -1) {
                cnt2++;
                prev2 = arr[j];
            }
            else if(prev2 != arr[j]) {
                prev2 = arr[j];
                cnt2++;
            }
        }
        
        if(idx1 < idx && idx > 0 && arr[idx] == arr[idx-1]) {
            cnt1--;
        }
        
        if(idx2 > idx && idx < n-1 && arr[idx] == arr[idx+1]) {
            cnt2--;
        }
        
        int ans = Math.min(cnt1, cnt2) + Math.abs(cnt1-cnt2) + 1;
        
        return ans==1?0:ans;
    }
}
