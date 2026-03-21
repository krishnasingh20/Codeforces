import java.util.*;
public class Array {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(solve(n, arr));
        }
    }

    public static String solve(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            int minC = 0;
            int maxC = 0;

            for(int j = i+1; j < n; j++) {
                if(arr[j] > arr[i]) {
                    maxC++;
                }
                else if(arr[j] < arr[i]) {
                    minC++;
                }
            }

            sb.append(Math.max(minC, maxC)).append(' ');
        }

        return sb.toString();
    }
}
