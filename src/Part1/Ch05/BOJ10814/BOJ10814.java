package Part1.Ch05.BOJ10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, age, i;
        String str, name;
        StringTokenizer st;

        // member클래스 정의
        N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];

        // 입력받기
        for(i=0;i<N;i++){
            str = br.readLine();
            st = new StringTokenizer(str);

            age = Integer.parseInt(st.nextToken());
            name = st.nextToken();
            members[i] = new Member(i, age, name);
        }

        // 정렬하기, 나이 어린 순 -> 같으면 입력받은 순
        Arrays.sort(members);

        // 출력하기
        for(i=0;i<N;i++){
            System.out.println(members[i].getAge() + " " + members[i].getName());
        }
    }
}
