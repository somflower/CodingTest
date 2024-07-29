package Part1.Ch05.BOJ2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, C, i, key;
        String str;
        StringTokenizer st;
        Map<Integer, Integer> map = new LinkedHashMap<>();

        str = br.readLine();
        st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        str = br.readLine();
        st = new StringTokenizer(str);
        for(i=0;i<N;i++){
            key = Integer.parseInt(st.nextToken());
            if(!map.containsKey(key)) // 처음 입력받은 수 일때
                map.put(key, 1);
            else
                map.put(key, map.get(key) + 1);
        }

//        map.forEach((k, v) -> System.out.println(k + " : " + v));

        // 제일 큰 값 찾아서 배열에 추가 -> map에서 삭제 -> map 빌때까지 반복
        while(!map.isEmpty()){
            Map.Entry<Integer, Integer> maxEntry = Collections.max(map.entrySet(), Map.Entry.comparingByValue());

            for(i=0;i<maxEntry.getValue();i++)
                System.out.print(maxEntry.getKey() + " ");

            map.remove(maxEntry.getKey());
        }
    }
}
