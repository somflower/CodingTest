package Part1.Ch04.BOJ10448;

import java.io.*;

public class BOJ10448 {
    public static int recursiveCase(int K, int[] Tn, int n, int cnt){
        int i;

        // base case
        if(K == 0 && cnt == 3)
                return 1;
        if(cnt > 3 || K == 0)
                return 0;

        // recursive case
            for(i=n;i>0;i--){ // n = 4
//                System.out.println();
//                System.out.println("recursive i : " + i + " , K : " + K + " , cnt : " + cnt);

                if(K - Tn[i] >= 0){
                    if(recursiveCase(K - Tn[i], Tn, n, cnt + 1) == 1) // 3개의 삼각수의 합일때
                        return 1;
                }
        }
        return 0;
    }


    public static int checkThreeTn(int K, int[] Tn){
        int i, n, ans = 0;

        for(i=1;i<45;i++){
            if(Tn[i] > K)
                break;
        }
//        System.out.println("* checkThreeTn *");

        // K보다 작으면서 제일 큰 Tn[i] 인덱스 저장
        n = i - 1;
//        System.out.println("n : " + n);
//        System.out.println();

        for(i=n;i>0;i--){
            ans = recursiveCase(K, Tn, n, 0);

//            System.out.println("i : " + i + " , ans : " + ans);

            if (ans == 1) // 3개의 삼각수 합으로 이뤄질때
                break;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T, K, i;
        int[] Tn = new int[45];

        // Tn 배열 생성
        for(i=1;i<45;i++){
            Tn[i] = (i * (i + 1)) / 2;
        }

        // Tn 배열 확인용 출력
//        for(i=1;i<45;i++)
//            System.out.print(Tn[i]+" ");
//        System.out.println();


        T = Integer.parseInt(br.readLine());

//        System.out.println("* main *");

        for(i=0;i<T;i++){
            K = Integer.parseInt(br.readLine());
            bw.write(checkThreeTn(K, Tn) + "\n");
            bw.flush();
        }

    }
}
