package Part1.Ch05.BOJ1931;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1931 {
//    public static int recursiveCase(Meeting[] meetings, int i, int N, int cnt){
//        int j;
//
//        // baseCase
//
//        for(j=i+1;j<N;j++){ // j = 2
////            System.out.println("j : " + j + " cnt : " + cnt);
//           if(meetings[j].getTerm() <= (meetings[j].getEnd() - meetings[i].getEnd()))
//               return recursiveCase(meetings, j, N, cnt + 1);
//        }
//
//        return cnt;
//    }
//
//    public static int checkMeetings(Meeting[] meetings, int N){
//        int i, max = -999, ans, cnt = 1;
//
//        for(i=0;i<N;i++){
////            System.out.println("i : " + i);
//            ans = recursiveCase(meetings, i, N, cnt);
////            System.out.println(i + "번째로 시작할때 ans : " + ans);
//
//            if(ans > max)
//                max = ans;
//        }
//
//        return max;
//    }


    public static void main(String[] args) throws IOException {
        // 사용자 정의 클래스 하나 만들고, start, end, term(차이) 필드 3개 주기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N, i, j, start, end, cnt = 1;
        String str;
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];

        // 입력
        for(i=0;i<N;i++){
            str = br.readLine();
            st = new StringTokenizer(str);

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end, end - start);
        }

        // end를 기준으로 정렬
        Arrays.sort(meetings);

        // 재귀 --> 시간복잡도 문제로 탈락
//        bw.write(checkMeetings(meetings, N) + "");
//        bw.flush();

        // 그리디 알고리즘으로 풀기!!
        // meetings[0]은 이미 선택함 -> [1]부터 확인하기
        i = 0;
        for(j=1;j<N;j++){
            if(meetings[j].getTerm() <= (meetings[j].getEnd() - meetings[i].getEnd())) {
                cnt++;
                i = j;
            }
        }

        System.out.println(cnt);
//        System.out.println();
//        for(i=0;i<N;i++)
//            System.out.println(meetings[i].getStart() + " " + meetings[i].getEnd() + " " + meetings[i].getTerm());
    }
}
