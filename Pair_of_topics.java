import java.util.*;

public class Pair_of_topics {

    static class Fenwick {
        int n;
        int[] bit;

        public Fenwick(int n) {
            this.n = n;
            bit = new int[n+1];
        }

        void update(int i, int val) {
            while(i <= n) {
                bit[i] += val;
                i += (i & -i);
            }
        }

        int query(int i) {
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

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        System.out.println(solve(n, a, b));
    }

    public static long solve(int n, int[] a, int[] b) {
        List<Integer> temp = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            temp.add((a[i] - b[i]));
            temp.add((b[i] - a[i]));
        }

        Collections.sort(temp);

        int idx = 1;
        HashMap<Integer, Integer> compress = new HashMap<>();
        compress.put(temp.get(0), idx);

        for(int i = 1; i < temp.size(); i++) {
            if(temp.get(i) != temp.get(i-1)) {
                compress.put(temp.get(i), ++idx);
            }
        }

        Fenwick f =  new Fenwick(idx);

        long ans = 0;

        for(int i = n-1; i >= 0; i--) {
            int id = compress.get((a[i]-b[i]));
            ans += f.query(id-1);

            id = compress.get((b[i]-a[i]));
            f.update(id, 1);
        }

        return ans;
    }
}
