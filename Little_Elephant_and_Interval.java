import java.util.Scanner;

public class Little_Elephant_and_Interval {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long l = sc.nextLong();
        long r = sc.nextLong();

        System.out.println(solve(l, r));
    }

    public static long solve(long l, long r) {
        String s1 = String.valueOf(r);
        String s2 = String.valueOf((l-1));

        dp = new Long[s1.length()][2][2][10][10];
        long ans1 = count(s1, 0, 1, 1, 0, 0);

        dp = new Long[s2.length()][2][2][10][10];
        long ans2 = count(s2, 0, 1, 1, 0, 0);

        return ans1 - ans2;
    }

    static Long[][][][][] dp;

    private static long count(String s, int i, int t, int lz, int si, int ei) {
        if(i == s.length()) {
            if(si == ei) {
                return 1;
            }
            return 0;
        }

        if(t == 0 && lz == 0 && dp[i][t][lz][si][ei] != null) {
            return dp[i][t][lz][si][ei];
        }

        int lb = 0;
        int ub = (t==1)?(s.charAt(i)-'0'):9;

        long res = 0;

        for(int d = lb; d <= ub; d++) {
            int newT = (t==1 && d==ub)?1:0;
            int newLz = (lz==1 && d==0)?1:0;
            int newSi = (lz==1)?d:si;

            res += count(s, i+1, newT, newLz, newSi, d);
        }

        if(lz == 0 && t == 0) {
            dp[i][t][lz][si][ei] = res;
        }

        return res;
    }
}
