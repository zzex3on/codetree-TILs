import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = -101;

        int arr[] = new int[n+1];
        int prefixSum[] = new int[n+1];
        prefixSum[0] = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(k <= 2) {
            for(int i = k; i <= n; i++) 
                prefixSum[i] = arr[i-1] + arr[i];
        } else {
            for(int i = k; i <= n; i++) 
                prefixSum[i] = prefixSum[i-1] + arr[i] - prefixSum[i-k];
        }

        for(int i = 0; i <= n; i++) {
            result = Math.max(result, prefixSum[i]);
        }

        sb.append(result);
        System.out.print(sb);

    }
}