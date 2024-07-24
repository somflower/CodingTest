package Part1.Ch01.BOJ1543;

import java.util.Scanner;

public class BOJ1543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String key = sc.nextLine();
        int i, j, k, result = 0;

        for(i=0;i<str.length();i++){
            j = i;
            for(k=0;k<key.length();k++){
                if(j == str.length()) // key는 남아있는데 str이 끝난 경우, 이 조건이 없으면 에러남
                    break;
                else if(str.charAt(j) == key.charAt(k)) // 같으면 다음글자 비교
                    j++;
                else // 다르면 끝
                    break;
            }
            if(k == key.length()){ // str에 key가 있다면
                result++;
                i = j - 1; // 반복문에서 i++되므로 -1해주어야 함
            }
        }
        System.out.println(result);


        /*int cnt = 0;
        int startIdx = 0;
        while(true){
            int findIdx = str.indexOf(key, startIdx);
            if(findIdx < 0)
                break;
            cnt++;
            startIdx = findIdx + key.length();
        }
        System.out.println(cnt);*/

        /*String replaced = str.replace(key, ""); // key와 같으면 ""으로 변환
        result = (str.length() - replaced.length()) / key.length();
        System.out.println(result);*/


    }
}
