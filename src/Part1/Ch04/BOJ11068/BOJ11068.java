package Part1.Ch04.BOJ11068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11068 {
    public static int checkNtoBPalindrome(int N, int B){
        // 10 -> 2^3*1 + 2^2*0 + 2^1*1 + 2^0*0, 이렇게 만들거고, *? 이 ?를 배열에 저장함, 그 배열을 palindrome 검사
        // N은 int여야 함
        // B진법으로 바꿀때 최대 B^ 지수 먼저 찾기 -> 자릿수 : 최대지수 + 1

        int i, j, max = 1, maxExponent, Nidx;
        char[] NtoBCharArr;
        String str;
        //Nidx 는 B진법 변환시 자릿수 -> 배열 크기 뜻함
        //maxExponent 는 B진법 변환시 최대지수

        // 자릿수와 최대지수 찾기
        for(i=0;N>max;i++){
            max *= B;
        }

        Nidx = i; // 자릿수
        maxExponent = Nidx - 1; // 최대지수
        NtoBCharArr = new char[Nidx]; // B^(maxExponent) * ? -> ? 저장할 배열 크기 맞춰 생성

//         N - B^max지수*012..~B-1 해서 B^max지수*? ?자리 찾기
//         반복해서 배열에 [0]15 [1]15 이런식으로 저장하기
//         checkPalindrome 함수 이용해서 확인
//
//        max = 1;
//        for(j=0;j<maxExponent;j++)
//            max *= B; // 1 * 16 -> max = 16
//
//        for(i=0; ;i++){
//            if(max * i > N)
//                break;
//        }
//         16^2*15 > N 이라 break 걸림.. 그러면
//        NcharArr[0] = N - max * (i - 1); //해서 저장..
//         반복해서 N이 B보다 작으면 끝남

        for(i=0;i<Nidx;i++){
            max = 1;
            for(j=0;j<maxExponent - i;j++){ // B^(maxExponent) * ? 에서 ?를 구하기 위해 B^(maxExponent)를 계산 -> max에 저장
                max *= B;
            }

            for(j=1;j<B;j++){ // B^(maxExponent) * ? 에서 ?값 찾기
                if(max * j > N)
                    break;
            }
            NtoBCharArr[i] = (char)(j - 1); // ?자리 찾은거 저장
            N -= max * NtoBCharArr[i];
        }

        // 만든 배열을 String으로 바꿔서 palindrome 확인
        str = new String(NtoBCharArr);
        if(CheckPalindrome(str) == 1)
            return 1;
        else
            return 0;
    }


    public static int CheckPalindrome(String N){
        // String N에 대해 Palindrome 확인
        int i, Nidx;

        Nidx = N.length();

        // Palindrome 확인하기
        for(i=0;i<Nidx/2;i++){
            if(N.charAt(i) != N.charAt(Nidx - i - 1))
                break;
        }

        if(i == Nidx/2)
            return 1;
        else
            return 0;
    }

    public static int NtoBPalindrome(int N){
        int i, j;
        String Nstr = N + "";

        if(CheckPalindrome(Nstr) == 1) // 처음에 입력받은 N이 Palindrome 이면 1반환
            return 1;
        else{ // Palindrome이 아니면 진법변환하고 Palindrome 확인
            for(i=2;i<65;i++){
                if(checkNtoBPalindrome(N, i) == 1) // i진법으로 변환한 N이 Palindrome 이면 1반환
                    return 1;
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T, i, N;

        T = Integer.parseInt(br.readLine());

        for(i=0;i<T;i++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(NtoBPalindrome(N));
        }


        // B진법 변환시 실제로 무슨 문자인지 확인할 필요가 X
        // String으로 N을 받고
        // String 글자수 세기를 해서 몇자리인지 알아낸 다음
        // 한 글자씩 비교하기
    }
}
