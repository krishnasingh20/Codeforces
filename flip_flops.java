import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {

            int n = sc.nextInt();
            long c = sc.nextLong();
            long k = sc.nextLong();

            PriorityQueue<Long> pq = new PriorityQueue<>();

            for(int i = 0; i < n; i++) {
                long x = sc.nextLong();
                pq.add(x);
            }

            while(!pq.isEmpty() && pq.peek() <= c) {
                long x  = pq.poll();
                long diff = c - x;

                if(k >= diff) {
                    c += diff;
                    k -= diff;
                    c += x;
                }
                else {
                    c += k + x;
                    k = 0;
                }
            }

            System.out.println(c);
        }
    }
}
