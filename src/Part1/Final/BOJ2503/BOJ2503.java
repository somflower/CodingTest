package Part1.Final.BOJ2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ2503 {
    // 123부터 987까지 돌면서 해당 숫자가 각각 질문들에 걸러지는 숫자인지 확인하기
    // ex) 질문 123 1 1, 확인 할 숫자 123 -> 123스트라이크 -> 탈락
    // 124 -> 12 스트라이크 -> 탈락
    // 136 -> 1 스트라이크 1볼 -> 유지
    public static void checkQuestions(ArrayList<String> candidates, int N, int[][] questions){
        int i, j, strike, ball;
        String candi;
        Iterator<String> iterator = candidates.iterator();

        while(iterator.hasNext()){
            candi = iterator.next();

            for(i=0;i<N;i++) {
                strike = 0;
                ball = 0;

                for(j=0;j<3;j++){
                    //strike와 ball 계산
                    if(candi.charAt(j) == (questions[i][0]+"").charAt(j))
                        strike++;
                    else if(candi.contains((questions[i][0]+"").charAt(j)+"")){
                        ball++;
                    }
                }

                // 후보 숫자에 대해 스트라이크와 볼을 계산했을때 틀린 경우
                if(strike != questions[i][1] || ball != questions[i][2]) {
                    iterator.remove();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, i;
        String str;
        ArrayList<String> candidates = new ArrayList<>();
        StringTokenizer st;

        //후보 숫자 list 초기화
        for(i=123;i<988;i++){
            str = String.valueOf(i);
            if(!str.contains("0")&&(str.charAt(0) != str.charAt(1))
                    &&(str.charAt(0) != str.charAt(2))&&(str.charAt(1) != str.charAt(2)))
                candidates.add(str);
        }

        N = Integer.parseInt(br.readLine());
        int[][] questions = new int[N][3];

        // 질문 입력 받기
        for(i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            questions[i][0] = Integer.parseInt(st.nextToken());
            questions[i][1] = Integer.parseInt(st.nextToken());
            questions[i][2] = Integer.parseInt(st.nextToken());
        }

        checkQuestions(candidates, N, questions);

        System.out.println(candidates.size());
    }
}