package Part1.Ch07.BOJ6236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이진트리 문제는 탐색할 범위를 정하는게 중요함!
public class BOJ6236 {
    public static int countWithdraw(int[] spending, int money, int M){
        int wallet = money, i = 0, cnt = 1; // 1번 인출함

        while(i < spending.length){
            if(wallet >= spending[i])
                wallet -= spending[i++];
            else{
                wallet = money; // 돈을 빼고 다시 저장함
                cnt++;
                wallet -= spending[i++];
            }
        }
        return cnt;
    }

    public static int binarySearchLoop(int[] spending, int low, int high, int M){
        int mid, result, ans = 0;

        while(low <= high){
            mid = (low + high) / 2;
            result = countWithdraw(spending, mid, M);

            if(result <= M){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, i, totalMoney = 0, max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] spending = new int[N];

        for(i=0;i<N;i++) {
            spending[i] = Integer.parseInt(br.readLine());
            totalMoney += spending[i];

            if(spending[i] > max)
                max = spending[i];
        }

        System.out.println(binarySearchLoop(spending, max, totalMoney, M));
    }


}
/*
*+500
-100
=400
-400
=0
*+500
-300
=200
-100
=100
*-100 + 500
-500
=0
*+500
-101
=399
*-399+500
-400
=100
 */