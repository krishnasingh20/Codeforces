import java.util.*;

public class Circular_RMQ {
    
    static class SegmentTree {
        long[] seg;
        long[] lazy;
        int n;
        public SegmentTree(int n) {
            this.n = n;
            seg = new long[4*n];
            lazy = new long[4*n];
        }
        
        void build(int node, int start, int end, int[] arr) {
            if(start == end) {
                seg[node] = arr[start];
                return;
            }
            
            int mid = (start + end)/2;
            
            build(2*node, start, mid, arr);
            build(2*node + 1, mid + 1, end, arr);
            
            seg[node] = Math.min(seg[2*node], seg[2*node+1]);
        }
        
        void push(int node, int start, int end) {
            if(lazy[node] != 0) {
                seg[node] += lazy[node];
                
                if(start != end) {
                    lazy[2*node] += lazy[node];
                    lazy[2*node+1] += lazy[node];
                }
                
                lazy[node] = 0;
            }
        }
        
        void update(int node, int start, int end, int ql, int qr, int val) {
            push(node, start, end);
            
            if(start > qr || end < ql) {
                return;
            }
            
            if(start >= ql && end <= qr) {
                lazy[node] += val;
                push(node, start, end);
                return;
            }
            
            int mid = (start + end)/2;
            
            update(2*node, start, mid, ql, qr, val);
            update(2*node + 1, mid + 1, end, ql, qr, val);
            
            seg[node] = Math.min(seg[2*node], seg[2*node+1]);
        }
        
        long query(int node, int start, int end, int ql, int qr) {
            push(node, start, end);
            
            if(start > qr || end < ql) {
                return Long.MAX_VALUE;
            }
            
            if(start >= ql && end <= qr) {
                return seg[node];
            }
            
            int mid = (start + end)/2;
            
            return Math.min(query(2*node, start, mid, ql, qr), query(2*node+1, mid + 1, end, ql, qr));
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder out = new StringBuilder();
        
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int m = sc.nextInt();
        sc.nextLine();
        
        SegmentTree sg = new SegmentTree(n);
        sg.build(1, 0, n-1, arr);
        
        for(int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] str = s.split("\\s+");
            
            int ql = Integer.parseInt(str[0]);
            int qr = Integer.parseInt(str[1]);
            
            if(str.length == 3) {
                int val = Integer.parseInt(str[2]);
                
                if(qr < ql) {
                    sg.update(1, 0, n-1, 0, qr, val);
                    sg.update(1, 0, n-1,ql, n-1, val);
                }
                else {
                    sg.update(1, 0, n-1, ql, qr, val);
                }
            }
            else {
                if(qr < ql) {
                    long min1 = sg.query(1, 0, n-1, 0, qr);
                    long min2 = sg.query(1, 0, n-1, ql, n-1);
                    out.append(Math.min(min1, min2)).append('\n');
                }
                else {
                    long min = sg.query(1, 0, n-1, ql, qr);
                    out.append(min).append('\n');
                }
            }
        }
        
        System.out.print(out);
    }
}
