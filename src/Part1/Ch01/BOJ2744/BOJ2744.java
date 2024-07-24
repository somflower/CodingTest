package Part1.Ch01.BOJ2744;

import java.util.*;

public class BOJ2744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int i;
        //String ans = ""; // 새 문자열에 값을 넣고싶을때

        str = sc.nextLine();

        for(i=0;i<str.length();i++){
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z') // 대문자일때
                System.out.print((char)(str.charAt(i)+32));
                //System.out.print((char)('a' + str.charAt(i) - 'A'));
                //ans += (char)('a' + str.charAt(i) - 'A');
            else if(str.charAt(i)>='a'&&str.charAt(i)<='z') // 소문자일때
                System.out.print((char)(str.charAt(i)-32));
                //System.out.print((char)('A' + str.charAt(i) - 'a'));
                //ans += (char)('A' + str.charAt(i) - 'a');
            else // 알파벳이 아닌 경우
                System.out.print((char)(str.charAt(i)));
        }
        //System.out.println(ans);
    }
}
