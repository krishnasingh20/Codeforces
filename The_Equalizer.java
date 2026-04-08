import java.util.*;

public class The_Equalizer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        
        int T = sc.nextInt();
        
        while(T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int sum = 0;
            
            for(int i = 0; i < n; i++) {
                sum += sc.nextInt();
            }
            
            if((sum & 1) == 1 || ((k*n) & 1) == 0) {
                out.append("YES").append('\n');
            }
            else {
                out.append("NO").append('\n');
            }
        }
        
        System.out.print(out);
    }
}
