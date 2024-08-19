package Part2.Ch01.BOJ1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K, N, M, i, j, flag, cnt = 0;
        StringTokenizer st;
        Queue<Document> queue = new LinkedList<>();

        K = Integer.parseInt(br.readLine());

        for(i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 큐 입력 받기
            st = new StringTokenizer(br.readLine());
            for(j=0;j<N;j++){
                queue.add(new Document(j,Integer.parseInt(st.nextToken())));
            }

            // M번째 문서가 몇번째로 인쇄되는지 찾기
            while(!queue.isEmpty()){
                flag = 0;
                Document current = queue.peek();

                for(Document doc : queue){ // 뒤에 현재보다 중요도가 높은 문서가 있는지 확인
                    if(doc.getPriority() > current.getPriority()){ // 있으면 뒤로 보내기
                        flag = 1; // 중요도 높은 문서가 뒤에 있다는 표시
                        queue.add(queue.poll());
                        break;
                    }
                }
                if(flag == 0){ // 현재보다 중요도가 높은 문서가 없음
                    Document printDc = queue.poll(); // 인쇄하기
                    cnt++; // 인쇄 횟수 세기
                    if(printDc.getIndex() == M){
                        System.out.println(cnt);
                    }
                }
            }
            cnt = 0;
        }
    }
}
