package Part1.Ch08.BOJ12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12891 {
//    public static int checkPassword(char[] password, int[] DNA, int P){
//        int i, j, cnt = 0;
//        int[] tmp = {DNA[0], DNA[1], DNA[2], DNA[3]};
//
//        // i~j까지 값이 DNA안이랑 같은지 확인 -> 확인할때마다 i~j 변해야함
//        // j가 인덱스범위를 넘어가면 안됨
//        for(j=P-1;j<password.length;j++){
//            i = j - P + 1; // i : 0(7-8+1) -> 1(8-8+1) -> 2(9-8+1) ..
//            while(i<=j){
//                if(password[i] == 'A')
//                    tmp[0]--;
//                else if(password[i] == 'C')
//                    tmp[1]--;
//                else if(password[i] == 'G')
//                    tmp[2]--;
//                else if(password[i] == 'T')
//                    tmp[3]--;
//                i++;
//            }
//            if(tmp[0] <= 0 && tmp[1] <= 0 && tmp[2] <= 0 && tmp[3] <= 0)
//                cnt++;
//
//            // 재 초기화
//            tmp[0] = DNA[0];
//            tmp[1] = DNA[1];
//            tmp[2] = DNA[2];
//            tmp[3] = DNA[3];
//        }
//        return cnt;
//    }

    public static int checkPasswordSlidingWindow(char[] password, int[] DNA, int P){
        int i = 0, j = P - 1, cnt = 0;
        int[] tmp = {DNA[0], DNA[1], DNA[2], DNA[3]};

        // 0~P-1 까지 확인해서 tmp 값 조정 -> 조건 맞는지 확인
        // 1~P 까지 확인 -> 이때 [0]빼고 [P] 추가하는 방식으로..
        while(i<=j){ // 첫 [0]~[P-1] 계산
            if(password[i] == 'A')          tmp[0]--;
            else if(password[i] == 'C')     tmp[1]--;
            else if(password[i] == 'G')     tmp[2]--;
            else if(password[i] == 'T')     tmp[3]--;
            i++;
        }
        if(tmp[0] <= 0 && tmp[1] <= 0 && tmp[2] <= 0 && tmp[3] <= 0)
            cnt++;

        i = 0;
        for(j=P;j<password.length;j++){
            if(password[i] == 'A')          tmp[0]++;
            else if(password[i] == 'C')     tmp[1]++;
            else if(password[i] == 'G')     tmp[2]++;
            else if(password[i] == 'T')     tmp[3]++;

            if(password[j] == 'A')          tmp[0]--;
            else if(password[j] == 'C')     tmp[1]--;
            else if(password[j] == 'G')     tmp[2]--;
            else if(password[j] == 'T')     tmp[3]--;

            if(tmp[0] <= 0 && tmp[1] <= 0 && tmp[2] <= 0 && tmp[3] <= 0)
                cnt++;
            i++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S, P, i;
        String str;
        int[] DNA = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        str = br.readLine();
        char[] password = str.toCharArray();

        st = new StringTokenizer(br.readLine());
        for(i=0;i<4;i++)
            DNA[i] = Integer.parseInt(st.nextToken());

//        System.out.println(checkPassword(password, DNA, P));
        System.out.println(checkPasswordSlidingWindow(password, DNA, P));
    }
}
