import java.util.*;
public class Wow_factor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        
        System.out.println(solve(s));
    }
    
    public static long solve(String s) {
        long total = 0;
        int count = 0;
        
        for(char c: s.toCharArray()) {
            if(c == 'o') {
                total += Math.max(0, count-1);
                count = 0;
            }
            else {
                count++;
            }
        }
        total += Math.max(0, count-1);
        
        long ans = 0;
        long curr = 0;
        count = 0;
        for(char c: s.toCharArray()) {
            if(c == 'o') {
                curr += Math.max(0, count-1);
                ans += curr*(total - curr);
                count = 0;
            }
            else {
                count++;
            }
        }
        
        return ans;
    }
}
