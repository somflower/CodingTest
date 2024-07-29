package Part1.Ch06.BOJ11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, i, j, x1, y1, x2, y2;
        int[][] arr;
        int[][] acc;
        String str;
        StringTokenizer st;


        str = br.readLine();
        st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        acc = new int[N+1][N+1];

        // arr배열 만들기
        for(i=1;i<=N;i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            for(j=1;j<=N;j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        // 누적합 구하기
        for(i=1;i<=N;i++){
            for(j=1;j<=N;j++){
//                if(i == 1) // [1][j]라인일때 -> [0][j]라인이 있어서 [1][1]을 위한 조건 안써도됨
//                    acc[i][j] = acc[i][j - 1] + arr[i][j];
//                else if (j == 1) // [i][1]라인일때 -> [i][0]라인이 있어서 [1][1]을 위한 조건 안써도됨
//                    acc[i][j] = acc[i - 1][j] + arr[i][j];
//                else
                    acc[i][j] = acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1] + arr[i][j];
            }
        }

        // x1, y1, x2, y2 입력
        for(i=0;i<M;i++){
            str = br.readLine();
            st = new StringTokenizer(str);

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            System.out.println(acc[x2][y2] - (acc[x1 - 1][y2] + acc[x2][y1 - 1]) + acc[x1 - 1][y1 - 1]);
        }

        // 누적합 출력
//        for(i=1;i<=N;i++){
//            for(j=1;j<=N;j++){
//                System.out.print(acc[i][j] + " ");
//            }
//        System.out.println();}

    }
}

/*
0 0 0 0 0
0 1 2 3 4
0 2 3 4 5
0 3 4 5 6
0 4 5 6 7

// 누적합, 11 부터 ij까지
0 0 0 0 0
0 1 3 6 10
0 3 8 15 24
0 6 15 27
0 10 24

0 0 0 0 0
0 1 3 6 10
0 3 8 19 34
0 6 19 43 83
0 10 34 83 173

9-1 = 8
9 = (1 + 2) + (1 + 2) + 3 -> 1을 두 번 더함
19 = ((1 + 2) + (1 + 2) + 3) + (1 + 2 + 3) + 4 // 9 + 6 + 4


19-7 = 12

 */
