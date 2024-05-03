import java.util.*;
import java.io.*;

public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;

    static int n, k;
    static int arr[];
    static int prefixSum[];
    static int result = INT_MIN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        prefixSum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        prefixSum[0] = 0;
        for(int i = 1; i <= n; i++) 
            prefixSum[i] = prefixSum[i-1] + arr[i];


        for(int i = 1; i <= n-k+1; i++) {
            result = Math.max(result, getSum(i, i+k-1));
            
            //System.out.println(prefixSum[i]);
        }

        sb.append(result);
        System.out.print(sb);

    }

    private static int getSum(int s, int e) {
        return prefixSum[e] - prefixSum[s-1];
    }
}