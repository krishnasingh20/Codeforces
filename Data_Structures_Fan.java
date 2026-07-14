import java.util.Scanner;

public class Data_Structures_Fan {
    static class SegmentTree {
        class Node {
            long one;
            long zero;
        }
        Node[] seg;
        int[] lazy;
        int n;
        public SegmentTree(int n, int[] arr, String s) {
            this.n = n;
            seg = new Node[4*n];
            lazy = new int[4*n];
            build(1, 0, n-1, arr, s);
        }

        void build(int node, int start, int end, int[] arr, String s) {
            if(start == end) {
                if(s.charAt(start) == '0') {
                    seg[node] = new Node();
                    seg[node].zero = arr[start];
                }
                else {
                    seg[node] = new Node();
                    seg[node].one = arr[start];
                }
                return;
            }

            int mid = (start + end) / 2;

            build(2*node, start, mid, arr, s);
            build(2*node + 1, mid+1, end, arr, s);

            seg[node] = new Node();
            seg[node].one = seg[2*node].one ^ seg[2*node+1].one;
            seg[node].zero = seg[2*node].zero ^ seg[2*node+1].zero;
        }

        void push(int node, int start, int end) {
            if(lazy[node] != 0) {
                if(lazy[node] % 2 != 0) {
                    long temp = seg[node].one;
                    seg[node].one = seg[node].zero;
                    seg[node].zero = temp;
                }

                if (start != end) {
                    lazy[2 * node] += lazy[node];
                    lazy[2 * node + 1] += lazy[node];
                }

                lazy[node] = 0;
            }
        }

        void update(int node, int start, int end, int ql, int qr) {
            push(node, start, end);

            if(start > qr || end < ql) {
                return;
            }

            if(start >= ql && end <= qr) {
                lazy[node] += 1;
                push(node, start, end);
                return;
            }

            int mid =  (start + end) / 2;

            update(2*node, start, mid, ql, qr);
            update(2*node + 1, mid+1, end, ql, qr);

            seg[node].one = seg[2*node].one ^ seg[2*node+1].one;
            seg[node].zero = seg[2*node].zero ^ seg[2*node+1].zero;
        }

        long query(int node, int start, int end, int idx) {
            push(node, start, end);
            if(idx == 0) {
                return seg[node].zero;
            }
            return seg[node].one;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            String s = sc.next();

            SegmentTree seg = new SegmentTree(n, arr, s);

            int q = sc.nextInt();

            for(int i = 0; i < q; i++) {
                int type = sc.nextInt();

                if (type == 1) {
                    int l = sc.nextInt() - 1;
                    int r = sc.nextInt() - 1;

                    seg.update(1, 0, n - 1, l, r);
                } else {
                    int idx = sc.nextInt();

                    long res = seg.query(1, 0, n - 1, idx);
                    out.append(res).append(' ');
                }
            }
            out.append('\n');
        }
        
        out.deleteCharAt(out.length() - 1);
        System.out.print(out);
    }
}
