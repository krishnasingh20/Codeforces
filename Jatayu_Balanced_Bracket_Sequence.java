import java.util.*;

public class Main {

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

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        int[] parent = new int[2*n];

        for(int i = 0; i < 2*n; i++) {
            if(s.charAt(i) == '(') {
                st.push(i);
            }
            else {
                parent[st.pop()] = st.peek()+1;
                parent[i] = st.peek()+1;
            }
        }

        HashSet<Integer> component = new HashSet<>();

        for(int i = 0; i < 2*n; i++) {
            component.add(parent[i]);
        }

        return component.size();
    } 

}
