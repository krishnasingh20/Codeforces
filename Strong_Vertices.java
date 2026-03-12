import java.util.*;

public class Strong_Vertices {

    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        
        StringBuilder out = new StringBuilder();

        int T = sc.nextInt();

        while(T-- > 0) {

            int n = sc.nextInt();
            long[] a = new long[n];

            for(int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            out.append(solve(n, a)).append('\n');
        }

        System.out.print(out);
    }

    public static String solve(int n, long[] a) {

        long max = Long.MIN_VALUE;
        int c = 0;

        for(int i = 0; i < n; i++) {
            long bi = sc.nextLong();
            a[i] = a[i] - bi;
            
            if(a[i] == max) {
                c++;
            }
            else if(a[i] > max) {
                max = a[i];
                c = 1;
            }
        }
    
        StringBuilder sb = new StringBuilder();
        sb.append(c).append('\n');
        
        for(int i = 0; i < n; i++) {
            if(a[i] == max) {
                sb.append((i+1)).append(' ');
            }
        }

        return sb.toString();
    }
}
