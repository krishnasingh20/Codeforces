import java.util.*;
public class Make_it_Divisible_by_25 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            long n = sc.nextLong();
            System.out.println(solve(n));
        }
        sc.close();
    }
    private static int solve(long n) {
        if(n % 25 == 0) {
            return 0;
        }
        String s = Long.toString(n);
        int ans = Integer.MAX_VALUE;
        int idx1 = -1;
        int idx2 = -1;
        //25
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '5') {
                if(idx1 == -1) {
                    idx1 = i;
                }
            }
            else if(s.charAt(i) == '2') {
                if(idx2 == -1 || (idx1 != -1 && idx2 > idx1)) {
                    idx2 = i;
                }
            }
        }
        if(idx1 != -1 && idx2 != -1 && idx2 < idx1) {
            int curr = (idx1-idx2-1) + (s.length()-idx1-1);
            ans = Math.min(ans, curr);
        }
        idx1 = -1;
        idx2 = -1;
        //50
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                if(idx1 == -1) {
                    idx1 = i;
                }
            }
            else if(s.charAt(i) == '5') {
                if(idx2 == -1 || (idx1 != -1 && idx2 > idx1)) {
                    idx2 = i;
                }
            }
        }
        if(idx1 != -1 && idx2 != -1 && idx2 < idx1) {
            int curr = (idx1-idx2-1) + (s.length()-idx1-1);
            ans = Math.min(ans, curr);
        }
        idx1 = -1;
        idx2 = -1;
        //75
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '5') {
                if(idx1 == -1) {
                    idx1 = i;
                }
            }
            else if(s.charAt(i) == '7') {
                if(idx2 == -1 || (idx1 != -1 && idx2 > idx1)) {
                    idx2 = i;
                }
            }
        }
        if(idx1 != -1 && idx2 != -1 && idx2 < idx1) {
            int curr = (idx1-idx2-1) + (s.length()-idx1-1);
            ans = Math.min(ans, curr);
        }
        idx1 = -1;
        idx2 = -1;
        //00
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                if(idx1 == -1) {
                    idx1 = i;
                }
                else if(idx2 == -1) {
                    idx2 = i;
                }
            }
        }
        if(idx1 != -1 && idx2 != -1 && idx2 < idx1) {
            int curr = (idx1-idx2-1) + (s.length()-idx1-1);
            ans = Math.min(ans, curr);
        }
        return ans;
    }
}
