package Part1.Ch05.BOJ1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1181 {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, i;

        N = Integer.parseInt(br.readLine());
        String[] strArr = new String[N];

        for(i=0;i<N;i++){
            strArr[i] = br.readLine();
        }

        // 길이로 정렬, 길이 같으면 알파벳으로 정렬, 람다식 사용
        Arrays.sort(strArr, (s1, s2) -> {  int lengthComparison = Integer.compare(s1.length(), s2.length());
            return lengthComparison != 0 ? lengthComparison : s1.compareTo(s2); // 참이면 lengthComparison을 반환하고, 거짓이면 s1.compareTo(s2)를 반환
            // s1.compareTo(s2)는 두 문자열을 사전 순서(알파벳순)로 비교
            // 두 문자열이 동일하면 0, s1이 s2보다 앞서면 음수, 뒤면 양수를 반환
        });

        // 중복 없이 출력
        System.out.println(strArr[0]);
        for(i=1;i<N;i++){
            if(!strArr[i - 1].equals(strArr[i]))
                System.out.println(strArr[i]);
        }
    }
}
