import java.util.*;

public class Find_The_Different_One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = 1;
        t = sc.nextInt();
        while(t-- > 0) {
            solve(sc, out);
        }

        out.deleteCharAt(out.length() - 1);
        System.out.print(out);
    }

    public static void solve(Scanner sc, StringBuilder out) {
        int n = sc.nextInt();

        int[] arr = new int[n+1];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] diff = new int[n];

        int i = 0;
        int j = 0;

        while(j < n) {
            while(i <= j && arr[j] != arr[i]) {
                diff[i] = j+1;
                i++;
            }
            j++;
        }

        while(i < n) {
            diff[i] = -1;
            i++;
        }

        int q = sc.nextInt();

        for(i = 0; i < q; i++) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;

            if(diff[l] == -1 || diff[l] > r+1) {
                out.append(-1).append(' ').append(-1).append('\n');
            }
            else {
                out.append((l+1)).append(' ').append(diff[l]).append('\n');
            }
        }

        out.append('\n');
    }
}
