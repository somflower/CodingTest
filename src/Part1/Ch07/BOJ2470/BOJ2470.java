package Part1.Ch07.BOJ2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, i, left = 0, right, closestSum = 1999999999, sol1 = 0, sol2 = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        right = N - 1;

        // 입력
        for (i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 정렬
        Arrays.sort(arr);

        // 두 포인터 사용
        while (left < right) {
            int sum = arr[left] + arr[right];

            // 현재 합이 0에 더 가까운지 확인 -> 음수 비교를 위해 절댓값 사용
            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;
                sol1 = arr[left];
                sol2 = arr[right];
            }

            // 두 용액의 합이 0과 가까워지도록 포인터 이동 -> 제일 큰 양수, 제일 작은 음수로 계산하기 때문에 아래와 같은 조건을 사용할 수 있음
            if (sum < 0) { // 음수인 경우 0을 만들기 위해 왼쪽에서 더 큰 수 선택
                left++;
            } else { // 양수인 경우 0을 만들기 위해 오른쪽에서 더 작은 수 선택
                right--;
            }
        }

        // 정답 출력
        System.out.println(sol1 + " " + sol2);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N, i, j, sol1 = 0, sol2 = 0 , searchResult, min = 999999999, calcResult;
//        String str;
//        StringTokenizer st;
//
//        N = Integer.parseInt(br.readLine());
//
//        int[] arr = new int[N];
//
//        str = br.readLine();
//        st = new StringTokenizer(str);
//
//        for(i=0;i<N;i++){
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        // 정렬
//        Arrays.sort(arr);
//
//        // 전부 음수&양수 인 경우
//        if(arr[0] >= 0){ // 전부 양수
//            sol1 = arr[0];
//            sol2 = arr[1];
//        }
//        else if(arr[N - 1] <= 0){ // 전부 음수
//            sol1 = arr[N - 2];
//            sol2 = arr[N - 1];
//        }
//        else{ // 음수&양수 섞인 경우
//            // 1. 정확히 일치하는 양수가 있는 경우 == 두 용액의 합이 0인 경우
//            for(i=0;arr[i]<0;i++){
//                searchResult = Arrays.binarySearch(arr, -arr[i]);
//                if(searchResult > 0){
//                    sol1 = arr[i];
//                    sol2 = arr[searchResult];
//                    break;
//                }
//            }
//
//            // 2. 없는 경우 -> binarySearch 반환값이 -insertoinPoint -1 인 것을 이용(해당 값이 없을때)
//            if(sol1 == sol2){ // 1.에서 정답을 찾지 못한 경우에 2. 실행
//                searchResult = Arrays.binarySearch(arr, 0);
//                for(i=0;arr[i]<0;i++){
//                    for(j=N-1;j>= -(searchResult + 1);j--){
//                        calcResult = arr[i] + arr[j];
//                        calcResult = (calcResult < 0) ? -calcResult : calcResult; // 계산 결과 음수인 경우 양수로 바꾸기
////                        System.out.println(arr[i] +" "+ arr[j] +" "+calcResult);
//
//                        if(calcResult < min){ // 0에 근접한지 비교
//                            min =  calcResult;
//                            sol1 = arr[i];
//                            sol2 = arr[j];
//                        }
//                    }
//                }
//                //제일 작은 양수끼리의 합이랑 제일 큰 음수끼리의 합 비교
//                if(arr[-(searchResult + 1)] + arr[-(searchResult)] < min){
//                    sol1 = arr[-(searchResult + 1)];
//                    sol2 = arr[-(searchResult)];
//                }
//                else if(-(arr[-(searchResult + 3)] + arr[-(searchResult + 2)]) < min){
//                    sol1 = arr[-(searchResult + 3)];
//                    sol2 = arr[-(searchResult + 2)];
//                }
//            }
//        }
//
//        // 정답 출력
//        System.out.println(sol1 + " " + sol2);
    }
}
