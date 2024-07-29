package Part1.Ch07.BOJ2295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, i, j, pick, max = -999, k = 0;
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        Set<Integer> twoSumSet = new HashSet<>();

        for(i=0;i<N;i++)
            arr[i] = Integer.parseInt(br.readLine());

        // arr 정렬
        Arrays.sort(arr);

        // 두 개의 합 저장
        for(i=0;i<N;i++){
            for(j=i;j<N;j++)
                twoSumSet.add(arr[i] + arr[j]);
        }

        // 세 번째 수를 선택하고, 선택된 수에서 두 수의 합을 뺀 결과가 HashSet에 있는지 확인, 18 - 10 = 8
        for(i=N-1;i>=0;i--){
            for (j = i - 1; j >= 0; j--) {
                pick = arr[i] - arr[j];
                if(twoSumSet.contains(pick) && arr[i] > max)
                    max = arr[i];
            }
        }

        // 출력
        System.out.println(max+"");


//        반복문 안에서 이진탐색을 하면서 시간초과가 발생함 -> HashSet 사용
//            for(i=0;i<N;i++)
//                arr[i] = Integer.parseInt(br.readLine());
//
//            // arr 정렬
//            Arrays.sort(arr);
//        // 두 개의 합 저장
//        int[] twoSumArr = new int[N * (N+1)/2];
//        for(i=0;i<N;i++){
//            for(j=i;j<N;j++)
//                twoSumArr[k++] = arr[i] + arr[j];
//        }
//
////        for(i=0;i<twoSumArr.length;i++){
////            System.out.print(twoSumArr[i] + " ");
////        }
////        System.out.println();
//
//        for(i=0;i<twoSumArr.length;i++){
//            for(j=0;j<N;j++){
//                pick = twoSumArr[i] + arr[j];
//                if(Arrays.binarySearch(arr, pick) >= 0){
////                    System.out.println("pick : " + pick);
//                    if(pick > max)
//                        max = pick;
//                }
//            }
//        }
//        System.out.println(max+"");
    }
}
/*
2 3 5 10 18
2 3 5 10 18

1 2 3
1 2 3
3 2 1 = 6
3*4/2 = 6
*/
