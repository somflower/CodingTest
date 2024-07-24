package Part1.Ch01.BOJ1157;

import java.util.Scanner;

public class BOJ1157 {
    // str에 영어 대소문자 개수 세는 함수
    /*public static int[] getAlphabetCount(String str){
        int[] count = new int[26];

        for(int i=0;i<str.length();i++)
            count[str.charAt(i) - 'A']++;

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase(); // 대문자로만 입력 받기
        int[] count = getAlphabetCount(str);
        int max = 0,max_idx = -1, i, flag=0;

        for(i=0;i<26;i++){
            if(count[i]>max){
                max = count[i];
                max_idx = i;
                flag = 0;
            }
            else if(count[i]==max) {
                flag = 1;
            }
        }

        if(flag == 1)
            System.out.println("?");
        else
            System.out.println((char)(max_idx+'A'));
    }
    */
    // 알파벳 한 글자를 가져와서 str과 비교하는 방법
    public static int getAlphabetCount(String str, char alp){
        int count = 0;

        for(int i=0;i<str.length();i++)
            if(alp == str.charAt(i))
                count++;

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase(); // 대문자로만 입력 받기
        int max = -1;
        char maxAlp = '?';

        for(char alp = 'A';alp<='Z';alp++){
            int count = getAlphabetCount(str, alp);
            if(count > max){
                max = count;
                maxAlp = alp;
            }
            else if(count == max) {
                maxAlp = '?';
            }
        }

        System.out.println((char)(maxAlp));
    }

}
