package Part1.Ch07.BOJ10816;


import java.io.*;
import java.util.*;

public class BOJ10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, M, i, key;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // map이랑 set에 저장
        for(i=0;i<N;i++){
            key = Integer.parseInt(st.nextToken());
            if(!map.containsKey(key)) { // 처음 입력받은 수 일때
                map.put(key, 1);
                set.add(key);
            }
            else
                map.put(key, map.get(key) + 1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(i=0;i<M;i++){
            key = Integer.parseInt(st.nextToken());
            if(set.contains(key))
                bw.write(map.get(key)+" ");
            else
                bw.write(0+" ");
        }
        bw.flush();
        bw.close();
    }
}

/*
map으로 입력받고 set에도 동시에 저장
출력할거 set으로 입력받고 -> 해당 값 set에 있는지 확인 -> 있으면 arr[해당값], 없으면 0출력

 */
