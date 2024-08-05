package Part1.Ch08.BOJ1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
//    public static int checkMinSubTotal(int[] sequence, int S) {
//        int i, mid, fcnt = 0, rcnt = 0, mcnt = 1, right, left;
//        long Sum = 0;
//
//        // 1. 앞에서부터 합
//        for (i = 0; Sum < S; i++) {
//            Sum += sequence[i];
//            fcnt++;
//        }
//
//        // 2. 뒤에서부터 합
//        Sum = 0;
//        for (i = sequence.length - 1; Sum < S; i--) {
//            Sum += sequence[i];
//            rcnt++;
//        }
//
//        // 3. 가운데부터 합
//        Sum = sequence[(sequence.length - 1)  / 2]; // 가운데는 이미 더하고 시작
//        for (i = (sequence.length - 1) / 2, right = i - 1, left = i + 1; Sum < S; i--) {
//            if (left >= 0 && right <= sequence.length - 1) { // 좌우 다 있을때는 비교해서 큰 값더하기
//                if (sequence[right] >= sequence[left]) {
//                    Sum += sequence[right++];
//                    mcnt++;
//                } else {
//                    Sum += sequence[left--];
//                    mcnt++;
//                }
//            } else if (left >= 0 && right > sequence.length - 1) { // 오른쪽에 더 값이 X
//                Sum += sequence[left--];
//                mcnt++;
//            } else if (left < 0 && right <= sequence.length - 1) { // 왼쪽에 더 값이 X
//                Sum += sequence[right++];
//                mcnt++;
//            }
//        }
//
//        return (fcnt < rcnt ? (Math.min(fcnt, mcnt)) : (Math.min(rcnt, mcnt)));
//    }

    public static int twoPointerSubTotal(int[] sequence, int S){
        int i = 0, j, min = 100000001;
        long sum = 0;

        for(j=0;j<sequence.length;j++){
            sum += sequence[j];
            while(sum >= S){
                min = Math.min((j - i + 1), min);
                sum -= sequence[i];
                i++;
            }
        }

        return (min == 100000001) ? 0 : min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, S, i;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] sequence = new int[N];

        st = new StringTokenizer(br.readLine());
        for(i=0;i<N;i++)
            sequence[i] = Integer.parseInt(st.nextToken());


        System.out.println(twoPointerSubTotal(sequence, S));
        //System.out.println(checkMinSubTotal(sequence, S));

    }
}
