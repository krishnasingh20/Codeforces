import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
public class Greetings {
    static class Fenwick {
        int n;
        int[] bit;
        public Fenwick(int n) {
            this.n = n;
            bit = new int[n+1];
        }
        public void update(int i, int val) {
            while(i <= n) {
                bit[i] += val;
                i += (i & -i);
            }
        }
        public int query(int i) {
            int sum = 0;
            while(i > 0) {
                sum += bit[i];
                i -= (i & -i);
            }
            return sum;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for(int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            System.out.println(solve(n, arr));
        }
        sc.close();
    }
    public static long solve(int n, int[][] arr) {
        Arrays.sort(arr, (a, b)->Integer.compare(a[1], b[1]));
        int[] temp = new int[n];
        for(int i = 0; i < n; i++) {
            temp[i] = arr[i][0];
        }
        Arrays.sort(temp);
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 1;
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(temp[i])) {
                map.put(temp[i], idx++);
            }
        }
        Fenwick ft = new Fenwick(idx-1);
        long ans = 0;
        for(int i = 0; i < n; i++) {
            int id = map.get(arr[i][0]);
            int count = ft.query(id-1);
            ans += (i - count);
            ft.update(id, 1);
        }
        return ans;
    }
}
