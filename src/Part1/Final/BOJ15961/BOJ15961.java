package Part1.Final.BOJ15961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ15961 {

    public static int getMaxSushi(int[] sushi, int N, int k, int c){
        Map<Integer, Integer> sushiMap = new HashMap<>();
        int left = 0, right = 0, max = 0;

        // 서비스 초밥 먼저 추가
        sushiMap.put(c, 1);

        // 처음 window 설정
        while(right < k){
            sushiMap.put(sushi[right], sushiMap.getOrDefault(sushi[right], 0) + 1);
            right++;
        }

        right--;
        while(left < N){
            max = Math.max(max, sushiMap.size()); // 개수 구하기
//            System.out.println("left : "+left+" , right : "+right);

            right++;

            if(right >= N)
                right -= N;

            sushiMap.put(sushi[right], sushiMap.getOrDefault(sushi[right], 0) + 1);
            sushiMap.put(sushi[left], sushiMap.get(sushi[left]) - 1); // 초밥 하나 줄이기
            if(sushiMap.get(sushi[left]) == 0)
                sushiMap.remove(sushi[left]);
            left++;
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, d, k, c, i;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[N];

        for(i=0;i<N;i++)
            sushi[i] = Integer.parseInt(br.readLine());

        System.out.println(getMaxSushi(sushi, N, k, c));

    }
}
/*
0 1 2 3 4 5 6 7

0~3
1~4
...
5~0
6~1
7~2

 */
