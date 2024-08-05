package Part1.Ch08.BOJ11728;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, M, i, j;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arrA = new int[N];
        int[] arrB = new int[M];
        int[] arrAB = new int[N + M];

        st = new StringTokenizer(br.readLine());
        for(i=0;i<N;i++)    arrA[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(i=0;i<M;i++)    arrB[i] = Integer.parseInt(st.nextToken());

        i = 0;
        for(j=0;j<N;j++)
            arrAB[i++] = arrA[j];
        for(j=0;j<M;j++)
            arrAB[i++] = arrB[j];

        Arrays.sort(arrAB);

        for(i=0;i<N+M;i++)
            bw.write(arrAB[i] + " ");
        bw.flush();
    }

}
