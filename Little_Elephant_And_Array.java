import java.util.Arrays;
import java.util.Scanner;

public class Little_Elephant_And_Array {
    static class Query {
        int L;
        int R;
        int idx;
        Query(int L, int R, int idx) {
            this.L = L-1;
            this.R = R-1;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Query[] query = new Query[q];

        for (int i = 0; i < q; i++) {
            query[i] = new Query(sc.nextInt(), sc.nextInt(), i);
        }

        int[] ans = solve(n, arr, query, q);

        for(int a: ans) {
            out.append(a).append('\n');
        }

        System.out.print(out);
    }

    public static int[] solve(int n, int[] arr, Query[] query, int q) {

        int blockSize = (int)Math.sqrt(n);

        Arrays.sort(query, (a, b)-> {
            int blockA = a.L/blockSize;
            int blockB = b.L/blockSize;
            if(blockA != blockB){
                return Integer.compare(a.L, b.L);
            }
            return Integer.compare(a.R, b.R);
        });

        int[] ans = new int[q];
        int[] freq = new int[n+1];

        int currL = 0;
        int currR = -1;
        int currAns = 0;

        for(int i = 0; i < q; i++) {
            int L = query[i].L;
            int R = query[i].R;

            while(currR < R) {
                currR++;
                if(arr[currR] > n) {
                    continue;
                }
                if(freq[arr[currR]]+1 == arr[currR]) {
                    currAns++;
                }
                else if(freq[arr[currR]] == arr[currR]) {
                    currAns--;
                }
                freq[arr[currR]]++;
            }
            while(currR > R) {
                if(arr[currR] > n) {
                    currR--;
                    continue;
                }
                if(freq[arr[currR]] == arr[currR]) {
                    currAns--;
                }
                else if(freq[arr[currR]]-1 == arr[currR]) {
                    currAns++;
                }
                freq[arr[currR]]--;
                currR--;
            }
            while(currL > L) {
                currL--;
                if(arr[currL] > n) {
                    continue;
                }
                if(freq[arr[currL]]+1 == arr[currL]) {
                    currAns++;
                }
                else if(freq[arr[currL]] == arr[currL]) {
                    currAns--;
                }
                freq[arr[currL]]++;
            }
            while(currL < L) {
                if(arr[currL] > n) {
                    currL++;
                    continue;
                }
                if(freq[arr[currL]] == arr[currL]) {
                    currAns--;
                }
                else if(freq[arr[currL]]-1 == arr[currL]) {
                    currAns++;
                }
                freq[arr[currL]]--;
                currL++;
            }

            ans[query[i].idx] = currAns;
        }

        return ans;
    }
}
