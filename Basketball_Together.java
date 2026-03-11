import java.util.*;
public class Basketball_Together {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr, n, d));
    }
    public static int solve(int[] arr, int n, int d) {
        Arrays.sort(arr);

        int l = n;
        int ans = 0;

        for(int i = n-1; i >= 0; i--) {
            int req = (d/arr[i]) + 1;

            if(l < req) {
                return ans;
            }
            l -= req;
            ans++;
        }

        return ans;
    }
}
