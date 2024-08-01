package Part1.Ch07.BOJ2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
4 7
10 15 17 20
15

4 5
10 15 17 20  -> 0, 20, 10(22) -> 11, 20, 15(7) -> 16, 20, 18(2) -> 16, 17, 16(5)
16

4 3
10 15 17 20 -> 0, 20, 10(22) -> 11, 20, 15(7) -> 16, 20, 18(2) -> 16, 17, 16(5) -> 17, 17, 17(3)
17

4 8
10 15 17 20 -> 0, 20, 10(22) -> 11, 20, 15(7) -> 11, 14, 12(16) -> 13, 14, 13(13) -> 14, 14, 14(10)
14

4 4
10 15 17 20 -> 0, 20, 10(22) -> 11, 20, 15(7) -> 16, 20, 18(2) -> 16, 17, 16(5) -> 17, 17, 17(3)
16

3 20
10 10 10 ->
 */

public class BOJ2805 {
    public static long getWoodLength(int[] trees, int cutHeight) {
        int i;
        long sum = 0;

        for (i = trees.length - 1; i >= 0; i--) {
            if (trees[i] > cutHeight)
                sum += trees[i] - cutHeight;
        }
        return sum;
    }

//    public static int cuttingHeight(int[] trees, int M, int start, int end) {
//        int i;
//        long ans;
//
//        //중복된 나무 길이가 있는 경우
////        if(trees[start] == trees[end])
////            i = 0;
//////            for(i=0;i<trees[end];i++){
//////                ans = getWoodLength(trees, i);
//////                if (ans == M)
//////                    return i;
//////                else if(ans < M)
//////                    return (i - 1);
//////            }
//////            return (i - 1);
////        else
////            i = trees[start];
////
//        i = (trees[start] == trees[end]) ? 0 : trees[start];
//
////        System.out.println("start : "+ start + " , end : "+end);
////        System.out.println("i : "+ i);
//
//        for (; i < trees[end]; i++) {
//            ans = getWoodLength(trees, i);
//            if (ans == M)
//                return i;
//            else if(ans < M)
//                return (i - 1);
//        }
//        return (i - 1);
////        if(low == -1){ // 중복된 수..
////            for(i=0;i<trees[high];i++){
////                ans = getWoodLength(trees, i);
////                if(ans == M)
////                    return i;
////                if(ans < M)
////                    return i - 1;
////            }
////            return i - 1;
////        }
////
////        for(i=trees[low+1];i<trees[high];i++){
////            ans = getWoodLength(trees, i);
////            if(ans == M)
////                return i;
////        }
////        return i - 1;
//    }

    public static int binarySearchRecursion(int[] trees, int M, int low, int high) {
        int mid;
        long wood;

//        System.out.println("low : " + low + " , high : " + high + " , mid : " + mid);
//        System.out.println("mid : " + trees[mid]);
//        System.out.println(result);

        if (low <= high) {
            mid = (high + low)  / 2;
            wood = getWoodLength(trees, mid);

            if (wood == M) // 자른 나무들이랑 필요한 나무가 동일할때
                return mid;

            else if(low == high)  // 자른 나무들이랑 필요한 나무가 동일하지 않을때 -> 탐색은 끝났는데 정확한 답이 없음
                return wood > M ? mid : mid - 1; // 여유있게 잘라야하므로 현재 자른 나무이 더 큰 경우는 바로 리턴, 작은 경우는 -1 해서 리턴

            else if (wood > M) {
//                System.out.println("*");
                return binarySearchRecursion(trees, M, mid + 1, high);
            }
            else {
//                System.out.println("**");
                return binarySearchRecursion(trees, M, low, mid - 1);
            }
        }
        return -100; // 구색갖추기용, 절대 실행되지 않는 코드
    }

//     이진탐색을 값에 대해 하는게 아니라... 0부터 max 길이 중에 하는거구나
//    public static int binarySearchLoop(int[] trees, int M){
//        int low = 0, high = trees[trees.length - 1], result = 0, mid;
//        long wood;
//
//        while(low <= high){
//            mid = (low + high) / 2;
//
//
//        }
//
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, i;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (i = 0; i < N; i++)
            trees[i] = Integer.parseInt(st.nextToken());

        // 정렬
        Arrays.sort(trees);


//        System.out.println(binarySearchLoop());
        System.out.println(binarySearchRecursion(trees, M, 0, trees[N - 1]));

        // 중복되는 나무 크기 해결을 못함..
//        for(i=N-2;i>=0;i--){
//            sum += (trees[i+1] - trees[i]) * k++;
//
//            if(sum == M){
//                ans = trees[i];
//                break;
//            }
//            else if(sum > M){
//                sum -= (trees[i+1] - trees[i]) * (--k); // 이전 sum으로 되돌리기
////                System.out.println("sum : " +sum);
////                System.out.println("k : "+k);
////                System.out.println("i : "+i);
//                if((M - sum) % k == 0)
//                    ans = trees[i+1] - ((M - sum) / k);
//                else
//                    ans = trees[i+1] - ((M - sum) / k) - 1;
//                break;
//            }
//        }
//
//        System.out.println(ans);
    }
}

/*
4 7
10 15 17 20

정렬함
[N-1]번째 나무(20)랑 [N-2]번째 나무(17) 차이 계산 = 3 -> 3을 M이랑 비교 -> 작음 더 아래 나무 보기
[N-2]번째 나무(17)랑 [N-3]번째 나무(15) 차이 계산 = 2 -> 3 + 2, 2를 M이랑 비교 -> 같음, 답은 15


5 20
4 26 40 42 46

42랑 46 비교, 4 -> 4 < 20
40이랑 42 비교, 2 -> 2 + (4 + 2) = 8 < 20
26이랑 40 비교, 14 -> 14 + (2 + 14) + (4 + 2 + 14) = 50 > 20 -> 20보다 큼.. -> 26 < 답 < 40 인걸 알 수 있음 -> 이 순간 찾기

3개 나무를 잘라야함
더해진 수는 (40 - 26) * 3 = 42
2개 나무는 무조건 2와 6을 자르고, 3개 공통으로 20 - 8 =  12가 필요함
12 / 3 = 4 -> 각 나무당 4씩 더 자르면 됨 -> 40 - 4 = 36, 답은 36


4 8  일때..
10 15 17 20

[N-1]번째 나무(20)랑 [N-2]번째 나무(17) 차이 계산 = 3 -> 3을 M이랑 비교 -> 작음 더 아래 나무 보기
[N-2]번째 나무(17)랑 [N-3]번째 나무(15) 차이 계산 = 2 -> 2 + (3 + 2) = 7 < 8 -> 작음 더 아래 나무 보기
15랑 10 계산 = 5 -> 5 + (2 + 5) + (3 + 2 + 5) = 22 > 8 -> break
i = 0, k = 3, sum = 7
8 - 7 = 1
1 / 3  = 0 ... 1 - > 나무 3개에서 추가로 1개 벌목 -> 1개당 0.333.. 인데 불가능함 -> 여유있게 3개 더 벌목

3 20
10 10 10
답: 3



 */
