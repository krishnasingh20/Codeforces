import java.util.*;

public class Predominant_Frequency_Division {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            solve(sc);
        }
    }

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] middle = new boolean[n];
        TreeSet<Integer> set = new TreeSet<>();
        int curr = arr[n-1] == 3 ? -1 : 1;
        set.add(curr);

        for(int i = n - 2; i >= 0; i--) {
            curr += (arr[i] == 3 ? -1 : 1);
            Integer temp = set.floor(curr);
            if(temp != null) {
                middle[i] = true;
            }
            set.add(curr);
        }

        curr = 0;

        for(int i = 0; i < n - 1; i++) {
            curr += (arr[i] == 1 ? 1 : -1);
            if(curr >= 0 && middle[i+1]) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
