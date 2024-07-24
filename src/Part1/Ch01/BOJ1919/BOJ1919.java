package Part1.Ch01.BOJ1919;
import java.util.*;

public class BOJ1919 {
    public static int[] getAlphabetCount(String str){
        int[] count = new int[26];

        for(int i=0;i<str.length();i++)
            count[str.charAt(i)-'a']++;

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1, str2;
        int[] check_arr = new int[1000]; // str2의 중복 확인용 배열, 자동으로 0으로 초기화됨
        int cnt = 0;

        str1 = sc.nextLine();
        str2 = sc.nextLine();

        /*for(int i=0;i<str1.length();i++){
            for(int j=0;j<str2.length();j++){
                if((str1.charAt(i) == str2.charAt(j))&&(check_arr[j] == 0)){
                    cnt++;
                    check_arr[j] = 1;
                    break;
                }
            }
        }

        System.out.println((str1.length()+str2.length()) - (cnt*2));*/


        int ans = 0;
        int[] count1 = getAlphabetCount(str1);
        int[] count2 = getAlphabetCount(str2);

        for(int i=0;i<26;i++)
            ans += Math.abs(count1[i] - count2[i]); // 절대값을 취해서 계산함

        System.out.println(ans);
    }
}
