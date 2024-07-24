package Part1.Ch03.BOJ10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class mergeSort {
    // merge sort

    public static void merge(int[] arr, int start, int end, int q){ // 진짜 정렬하는 함수
        int i, j ,k;
        int[] mergeArr = new int[end - start + 1];
        // mergeArr은 합병정렬 결과 배열

        i = start; // i는 오른쪽 배열 idx
        j = q + 1; // j는 왼쪽 배열 idx
        k = 0; // k는 합병정렬 결과 배열의 idx

        // 오른쪽, 왼쪽 합치기
        while(i <= q && j <= end){
            if(arr[i] < arr[j]) // 오른쪽이 더 작을때
                mergeArr[k] = arr[i++]; // 오른쪽 값 하나 mergeArr에 넣었으므로 증가(i++)
            else
                mergeArr[k] = arr[j++]; // 왼쪽이 더 작을때, 왼쪽 값 하나 mergeArr에 넣었으므로 증가(j++)
            k++; // 하나 정렬했으므로 idx 증가(k++)
        }

        // 오른쪽, 왼쪽 중 어느 하나만 끝났을 경우 -> 남은거 그냥 mergeArr에 넣기
        if(i > q) // 오른쪽이 먼저 끝남
            for(; j<=end; j++,k++)
                mergeArr[k] = arr[j];
        else // 왼쪽이 먼저 끝남
            for(; i<=q; i++,k++)
                mergeArr[k] = arr[i];

        // 원래 배열에 붙여넣기
        for(i=start,k=0; i<=end; i++,k++){
            arr[i] = mergeArr[k];
        }
        return;
    }

    public static void mergeSort(int[] arr, int start, int end){ // 파티션 나누는 함수
        int q; // 반 나누는 idx

        // 반으로 쪼갠 후 오른쪽 정렬, 왼쪽 정렬, 합쳐서 정렬
        if(start < end){ // 배열이 1칸이 아닌 경우 -> 정렬이 필요함
            q = (start + end) / 2;
            mergeSort(arr, start, q);
            mergeSort(arr, q + 1, end);
            merge(arr, start, end, q);
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n, i;

        n = Integer.parseInt(bf.readLine()); // 개수 입력 받기

        int[] arr = new int[n]; // 개수에 맞춰 배열 생성

        for(i=0;i<n;i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }

        // 정렬하기
        mergeSort(arr, 0, n - 1);

        // 출력
        for(i=0;i<n;i++){
            System.out.println(arr[i]);
        }

    }

}
