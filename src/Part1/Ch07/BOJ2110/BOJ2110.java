package Part1.Ch07.BOJ2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    public static int checkRouter(int[] houses, int distance, int C){
        int cnt = 1, lastInstalled = houses[0], i = 1; // house[0]에는 이미 설치함

        for(i=1;i<houses.length;i++){
            if(houses[i] - lastInstalled >= distance){
                lastInstalled = houses[i];
                cnt++;
            }
            if(cnt == C)
                return 1;
        }

        return 0;
    }

    public static int binarySearchLoop(int[] houses, int C){
        int low = 1, high = houses[houses.length - 1] - houses[0], mid, ans = 0;

        while(low <= high){
            mid = (low + high) / 2;
            if(checkRouter(houses, mid, C) == 1){
                ans = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, C, i;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int[] houses = new int[N];

        for (i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        System.out.println(binarySearchLoop(houses, C));
    }

}
/*
1 2 3 4 5 6 7 8 9 10
low = 1, high = 9, mid = 5 / 1 2 3 4 *5 6 7 8 9

1 2 3 4 5 6 7 8 9 10
*         *           -> 안됨 -> high = mid - 1

low = 1, high = 4, mid = 2
1 2 3 4 5 6 7 8 9 10
*



---------------------------
1 2 4 8 9
low = 1, high = 8, mid = 4 / 1 2 3 *4 5 6 7 8

1 2 4 8 9
*     *   -> 안됨 -> high = mid - 1

low = 1, high = 3, mid = 2 / 1 *2 3
1 2 4 8 9
*   * *   -> 됨 -> 되는데 최댓값 찾아야하니 조금 더 큰걸로 해도 되는지 확인하기 -> low = mid + 1

low = 3, high = 3 , mid = 3 / *3
1 2 4 8 9
*   * *  -> 됨 -> 더 큰 값 있는지 찾기 -> low = mid + 1

low = 4, high = 3 -> 끝남



  5 4
1
3
5
10
11
답: 2

  1   3   5         10 11  -> mid는 공유기 설치시 최소 거리를 뜻함, 이진탐색 범위: 1~([n-1]-[0]), 공유기를 놓을 수 있는 최소~최대거리
  *   *   *          *

  1   3   5         10 11  ->  low = 1, high = 10, mid = 5 -> F리턴
  *                  *

  1   3   5         10 11  -> low = 1, high = 4, mid = 2
  *

  1   3   5         10 11  -> low = 1, high = 4, mid = 2 -> T리턴
  *   *   *          *

-------------
*           * -> 2개면 이렇게

-------------
*     *     * -> 3개면 이렇게

-------------
*   *   *   * -> 4개면 이렇게

 */