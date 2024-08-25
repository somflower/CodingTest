package Part2.Ch02.BOJ10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str;
        int i, cnt = 0;

        str = br.readLine();

        for(i=0;i<str.length();i++){
            if(str.charAt(i) == '('){
                if(str.charAt(i+1) == ')') { // 레이저를 확인하기
                    cnt += stack.size();
                    i++;
                }
                else {
                    stack.add(str.charAt(i));
                    cnt++;
                }
            }
            else
                stack.pop();
        }
        System.out.println(cnt);
    }

}
