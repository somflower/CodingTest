package Part1.Ch07.BOJ1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
3 1
2
4
6

 */
public class BOJ1654 {
//    public static int getMaxLANlength(int[] LANcables, int LANlength, int N){
//        int i;
//
//        for(i=LANlength;getLANcount(LANcables, i) == N; i++);
//        return (i - 1);
//    }

    public static int getLANcount(int[] LANcables, long LANlength){ // 이 함수를 실행한다는 것은 LANlength가 int범위임을 뜻함
        int i, cnt = 0;

        for(i=0;i<LANcables.length;i++){
            cnt += LANcables[i] / (int)LANlength;
        }
        return cnt;
    }

    public static long binarySearchRecursion(int[] LANcables, long low, long high, int N) {
        long mid;
        long LANcount;
        if(low > high)
            return high;

        else{
            mid = (high + low)  / 2;
//            System.out.println("mid : " + mid);
            LANcount = getLANcount(LANcables, mid); // 잘라서 몇개 나오는지 확인하기
//            System.out.println("low : " + low + " , high : " + high + " , mid : " + mid);
//            System.out.println("LANcount : "+LANcount);

//            if (LANcount == N){ // N개 만큼 만들 수 있는 길이일때
//                return getMaxLANlength(LANcables, (int)mid, N); // 최대인지 확인해서 반환
//            }
//            else if(low == high){
//                return LANcount > N ? mid : mid - 1;
//            }
            if (LANcount >= N) {
//                System.out.println("*");
                return binarySearchRecursion(LANcables, mid + 1, high, N);
            }
            else {
//                System.out.println("**");
                return binarySearchRecursion(LANcables,low, mid - 1, N);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K, N, i;
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] LANcables = new int[K];

        for (i = 0; i < K; i++)
            LANcables[i] = Integer.parseInt(br.readLine());

        //정렬
        Arrays.sort(LANcables);

        System.out.println(binarySearchRecursion(LANcables, 1, LANcables[K-1], N));
    }
}
