package Part1.Ch03.BOJ10989;

import java.io.*;

public class BOJ10989 {
    // count sort

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, i, j, input;

        n = Integer.parseInt(bf.readLine()); // 개수 입력 받기

        int[] cnt = new int[10001]; // 개수에 맞춰 배열 생성

        // 입력값 카운트해서 배열에 저장
        for(i=0;i<n;i++){
//            input = Integer.parseInt(bf.readLine());
//            for(j=1;j<=n;j++)
//                if(input == j)
//                    cnt[j]++;
            cnt[Integer.parseInt(bf.readLine())]++;
        }


        // 출력
        for(i=0;i<=10000;i++){
            for(j=0;j<cnt[i];j++)
                bw.write(i+"\n");
        }
        bw.flush();

    }

}
