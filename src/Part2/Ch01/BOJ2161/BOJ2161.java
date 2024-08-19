package Part2.Ch01.BOJ2161;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, i;
        Queue<Integer> queue = new LinkedList<>();

        N = Integer.parseInt(br.readLine());

        for(i=1;i<=N;i++)
            queue.add(i);

        while(queue.size() > 1){
            System.out.print(queue.poll()+" "); // 맨 앞 카드 버리기
            queue.add(queue.poll()); // 맨 앞 카드 뒤에 추가
        }
        System.out.println(queue.poll());
    }
}
