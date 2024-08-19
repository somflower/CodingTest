package Part1.Final.BOJ7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 {
    public static int countBigger(int[] arrA, int[] arrB, int N, int M){
        int i, low, high, cnt = 0, mid = 0;

        for(i=0;i<N;i++){
            low = 0;
            high = arrB.length - 1;

            while(low <= high){
                mid = (low + high) / 2;

                if(arrB[mid] < arrA[i])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            cnt += low;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, T, N, M;
        StringTokenizer st;
        int[] arrA;
        int[] arrB;

        T = Integer.parseInt(br.readLine());

        for(i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arrA = new int[N];
            arrB = new int[M];

            st = new StringTokenizer(br.readLine());
            for(j=0;j<N;j++)
                arrA[j] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(j=0;j<M;j++)
                arrB[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            System.out.println(countBigger(arrA, arrB, N, M));
        }
    }
}
