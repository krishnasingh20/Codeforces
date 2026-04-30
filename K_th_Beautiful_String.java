import java.util.*;
 
public class K_th_Beautiful_String {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            out.append(solve(n, k)).append('\n');
        }
        System.out.print(out);
    }
    
    public static String solve(int n, long k) {
        char[] ch = new char[n];
        int i = 0;
        int a = n-2;
        int b = 2;
        while(i < n) {
            long c = find(a-1, b);
            if(c >= k) {
                ch[i] = 'a';
                a--;
            }
            else {
                ch[i] = 'b';
                b--;
                k -= c;
            }
            i++;
            if(a == 0 || b == 0) {
                break;
            }
        }
        while(a-- > 0) {
            ch[i++] = 'a';
        }
        while(b-- > 0) {
            ch[i++] = 'b';
        }
        return new String(ch);
    }
    
    public static long find(int a, int b) {
        if(b == 1) {
            return a+b;
        }
        long n = (long)a+b;
        return (n * (n - 1)) / 2L;
    }
}
