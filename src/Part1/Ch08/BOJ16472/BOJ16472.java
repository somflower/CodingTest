package Part1.Ch08.BOJ16472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ16472 {
    public static int getMaxSubString(String str, int N){
        int right = 0, left = 0, max = 0;
        Map<Character, Integer> alphaMap = new HashMap<>();
        char rChar, lChar;

        while(right < str.length()){
            rChar = str.charAt(right);
            alphaMap.put(rChar, alphaMap.getOrDefault(rChar, 0) + 1); // getOrDefalut : key 없으면 0, 있으면 value 가져옴
            right++;

            while(alphaMap.size() > N){ // 알파벳 개수 커지면 left 늘리기
                lChar = str.charAt(left);
                alphaMap.put(lChar, alphaMap.get(lChar) - 1);
                if(alphaMap.get(lChar) == 0)
                    alphaMap.remove(lChar);
                left++;
            }

            max = Math.max(max, right - left);
        }

        return max;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int N;

        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        System.out.println(getMaxSubString(str, N));
    }
}
