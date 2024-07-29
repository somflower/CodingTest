package Part1.Ch07.BOJ14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, i, cnt = 0;
        String str;
        StringTokenizer st;

        str = br.readLine();
        st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 문자열 집합 S입력받기
        String[] S = new String[N];
        for (i = 0; i < N; i++) {
            S[i] = br.readLine();
        }

        // S 정렬하기
        Arrays.sort(S);

//        for(i=0;i<N;i++)
//            System.out.print(S[i] + " ");
//        System.out.println();


        // 검사할 문자열 배열 입력받기
        String[] strArr = new String[M];
        for (i = 0; i < M; i++) {
            strArr[i] = br.readLine();
        }
//        for(i=0;i<M;i++)
//            System.out.print(strArr[i] + " ");
//        System.out.println();


        // S에 문자열 있는지 찾기 -> 이진탐색으로
        for(i=0;i<M;i++){
            if(Arrays.binarySearch(S, strArr[i]) >= 0){
//                System.out.println(strArr[i]);
                cnt++;}
        }
        System.out.println(cnt+"");
    }
}
