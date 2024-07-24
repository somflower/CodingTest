package Part1.Ch04.BOJ2840;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ2840 {
    public static int checkAlphaValid(char[] charArr, int N){
        int i, j;

        for(i=0;i<N;i++){
            for(j=i+1;j<N;j++)
                if(charArr[i] != '?')
                    if(charArr[i] == charArr[j])
                        return 0;
        }
        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, K, S, i, idx = 0, flag = 1;
        char tmp;
        String str;
        StringTokenizer st;

        str = br.readLine();
        st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        char[] charArr = new char[N];
        
        for(i=0;i<K;i++){
            str = br.readLine();
            st = new StringTokenizer(str);

            S = Integer.parseInt(st.nextToken());
            tmp = st.nextToken().charAt(0);

            // 1. 배열 idx 확인, 2. 비었는지 확인
            if(idx + S >= N)
                idx = (idx + S) % N;
            else
                idx += S;

            if(charArr[idx] == '\u0000') // 해당 자리가 비어있을때
                charArr[idx] = tmp;
            else if(charArr[idx] != tmp) // 비어있지는 않은데 다른 알파벳일때
                flag = 0;
        }

        // 빈 자리 ? 로 바꾸기
        for(i=0;i<N;i++)
            if(charArr[i] == '\u0000')
                charArr[i] = '?';
        
        // 중복 알파벳 체크
        if(flag != 0)
            flag = checkAlphaValid(charArr, N);

        // 결과 출력
        if(flag == 0) // 같은 칸에 다른 알파벳인 경우 or 중복 알파벳 있는 경우
            System.out.println("!");
        
        // 행운의 바퀴가 아닌 경우 -> 함수 만들고 return 0해서 ! 출력


        else{ // 행운의 바퀴가 있거나 제대로된 룰렛인 경우
            for(i=0;i<N;i++)
                if(idx - i >= 0)
                    System.out.print(charArr[idx - i]);
                else
                    System.out.print(charArr[idx - i + N]);
            System.out.println();
        }
    }
}
