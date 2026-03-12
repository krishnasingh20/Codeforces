import java.util.*;

public class Point_on_line {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();
        long[] arr = new long[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        System.out.println(solve(n, d, arr));
    }

    public static long solve(int n, int d, long[] arr) {
        long ans = 0;
        int si = 0;

        for(int ei = 0; ei < n; ei++) {
            
            while(arr[ei] - arr[si] > d) {
                si++;
            }

            if(ei - si > 1) {
                long c = ei - si;
                ans += (c*(c-1))/2;
            }
        }

        return ans;
    }
}
