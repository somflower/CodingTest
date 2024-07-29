package Part1.Ch05.BOJ18870;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, i;
        String str;
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] sortedArr = new int[N];

        str = br.readLine();
        st = new StringTokenizer(str);
        for(i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sortedArr[i] = arr[i];
        }

        // 중복없이 저장한 배열 만들기 -> 정렬 먼저 필요
        Arrays.sort(sortedArr); // 정렬하기
        sortedArr = Arrays.stream(sortedArr).distinct().toArray(); // 중복 제거하기, 스트림으로 변환 후 중복 요소 제거,를 다시 배열로 변환


        // 이진탐색으로 값 같은거 찾기 -> O(nlogn)
        for(i=0;i<N;i++){
            bw.write(Arrays.binarySearch(sortedArr, arr[i]) + " ");
//            bw.flush(); // 시간초과함
        }
        bw.flush();
        bw.close();
    }
}
