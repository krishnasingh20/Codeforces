import java.util.Scanner;

public class Classy_number {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder out = new StringBuilder();

        int T = sc.nextInt();

        while(T-- > 0) {

            long l = sc.nextLong();
            long r = sc.nextLong();

            out.append(solve(l, r)).append('\n');
        }

        System.out.print(out);
    }

    public static long solve(long l, long r) {
        String s1 = String.valueOf(r);
        String s2 = String.valueOf((l-1));

        dp = new Long[s1.length()][2][s1.length()+1];
        long ans1 = count(String.valueOf(r), 0, 1, 0);

        dp = new Long[s2.length()][2][s2.length()+1];
        long ans2 = count(String.valueOf((l-1)), 0, 1, 0);

        return ans1 - ans2;
    }

    static Long[][][] dp;

    public static long count(String s, int i, int t,  int c) {
        if(i == s.length()) {
            if(c <= 3) {
                return 1;
            }
            return 0;
        }

        if(t == 0 && dp[i][t][c] != null) {
            return dp[i][t][c];
        }

        int lb = 0;
        int ub = (t==1)?(s.charAt(i)-'0'):9;

        long res = 0;
        for(int d = lb; d <= ub; d++) {
            int newC = c+(d>0?1:0);
            int newT = (t==1 && d == ub)?1:0;
            res += count(s, i+1, newT, newC);
        }

        if(t == 0) {
            dp[i][t][c] = res;
        }

        return res;
    }
}
