import java.util.Arrays;
import java.util.Scanner;
 
public class Powerful_Array {
 
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
        max = 0;
 
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
 
        Query[] query = new Query[q];
 
        for (int i = 0; i < q; i++) {
            query[i] = new Query(sc.nextInt(), sc.nextInt(), i);
        }
 
        long[] ans = solve(n, arr, query, q);
 
        for(long a: ans) {
            out.append(a).append('\n');
        }
 
        System.out.print(out);
    }
 
    static int max;
    
    public static long[] solve(int n, int[] arr, Query[] query, int q) {
 
        int blockSize = (int)Math.sqrt(n);
 
        Arrays.sort(query, (a, b)-> {
            int blockA = a.L/blockSize;
            int blockB = b.L/blockSize;
            if(blockA != blockB){
                return Integer.compare(blockA, blockB);
            }
            return Integer.compare(a.R, b.R);
        });
 
        long[] ans = new long[q];
        int[] freq = new int[max+1];
 
        int currL = 0;
        int currR = -1;
        long currAns = 0;
 
        for(int i = 0; i < q; i++) {
            int L = query[i].L;
            int R = query[i].R;
 
            while(currR < R) {
                currR++;
                currAns -= ((long)freq[arr[currR]]*freq[arr[currR]]*arr[currR]);
                freq[arr[currR]]++;
                currAns += ((long)freq[arr[currR]]*freq[arr[currR]]*arr[currR]);
            }
            
            while(currR > R) {
                currAns -= ((long)freq[arr[currR]]*freq[arr[currR]]*arr[currR]);
                freq[arr[currR]]--;
                currAns += ((long)freq[arr[currR]]*freq[arr[currR]]*arr[currR]);
                currR--;
            }
            
            while(currL > L) {
                currL--;
                currAns -= ((long)freq[arr[currL]]*freq[arr[currL]]*arr[currL]);
                freq[arr[currL]]++;
                currAns += ((long)freq[arr[currL]]*freq[arr[currL]]*arr[currL]);
            }
            
            while(currL < L) {
                currAns -= ((long)freq[arr[currL]]*freq[arr[currL]]*arr[currL]);
                freq[arr[currL]]--;
                currAns += ((long)freq[arr[currL]]*freq[arr[currL]]*arr[currL]);
                currL++;
            }
 
            ans[query[i].idx] = currAns;
        }
 
        return ans;
    }
}
