import java.util.*;

public class Jatayu_Balanced_Bracket_Sequence {

    static class DSU {
        int[] parent;
        int[] size;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int node) {
            if(node == parent[node]) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        void union(int a, int b) {
            int p1 = find(a);
            int p2 = find(b);

            if(p1 == p2) {
                return;
            }

            if(size[p1] > size[p2]) {
                parent[p2] = p1;
                size[p1] += size[p2];
            }
            else {
                parent[p1] = p2;
                size[p2] += size[p1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder out = new StringBuilder();

        int t = 1;
        t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();

            String s = sc.next();

            out.append(solve(n, s)).append('\n');
        }

        System.out.print(out);

        sc.close();
    }

    public static int solve(int n, String s) {

        DSU dsu = new DSU(2*n);

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for(int i = 0; i < 2*n; i++) {
            if(s.charAt(i) == '(') {
                st.push(i);
            }
            else {
                dsu.union(st.peek(), i);
                st.pop();
                dsu.union(st.peek()+1, i);
            }
        }

        HashSet<Integer> component = new HashSet<>();

        for(int i = 0; i < 2*n; i++) {
            component.add(dsu.find(i));
        }

        return component.size();
    } 

}
