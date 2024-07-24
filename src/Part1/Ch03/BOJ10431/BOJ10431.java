package Part1.Ch03.BOJ10431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10431 {
    // insertion sort
    // 그러나 직접 정렬할 필요는 X.. 그저 횟수만 필요 -> 직접 정렬해야함!!

    public static int insertion_sort(int[] arr, int size){
        int i, j, k, tmp, cnt = 0;
        // i는 이번 순서를 뜻함, arr[i]는 이번에 정렬할 값
        // k는 arr[i]의 알맞은 자리

        for(i=2;i<size;i++){
            for(j=1;j<i;j++){ // 정렬되지 않은 값(arr[i]) 넣을 자리 찾기
                if(arr[j] > arr[i]) // 정렬된 배열 안에서 arr[i]의 알맞은 자리를 찾은 경우
                    break;
            }
            if(j == i) // 예외처리, arr[i]의 현재 자리가 알맞은 자리인 경우 == arr[i]가 arr[i-1]보다 큰 수
                continue; // 정렬되어있으므로 다음 값 확인

            // arr[i]를 정렬된 배열 사이에 삽입
            tmp = arr[i]; // arr[i] tmp에 저장

            for(k=i;k>j;k--){ // arr[i-1]부터 한 칸씩 뒤로 미루기
                arr[k] = arr[k - 1];
                cnt++;
            }
            
            arr[k] = tmp; // arr[i]를 알맞은 자리에 넣기
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T, i, j;
        String str;
        StringTokenizer st;
        int [] arr = new int[21];

        T = Integer.parseInt(bf.readLine()); // 횟수 입력받기

        for(i=0;i<T;i++){
            str = bf.readLine(); // 한 줄 읽기
            st = new StringTokenizer(str);
            for(j=0;j<21;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(arr[0]+" "+insertion_sort(arr,21));
        }

//        for(i=0;i<21;i++)
//            System.out.print(arr[i] + " ");
//        System.out.println();

    }
}
