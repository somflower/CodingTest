package Part2.Ch02.BOJ4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str;
        int i, flag = 1;

        str = br.readLine();

        while(!str.equals(".")){
            for(i=0;i<str.length();i++){
                if(str.charAt(i) == '(' || str.charAt(i) == '[')
                    stack.push(str.charAt(i));
                else if(str.charAt(i) == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        flag = 0;
                        break;
                    }
                }
                else if(str.charAt(i) == ']'){
                    if(stack.isEmpty() || stack.pop() != '['){
                        flag = 0;
                        break;
                    }
                }
            }
            // 문장이 끝났는데 스택이 비어있지 않으면 균형이 아님
            if(!stack.isEmpty())
                flag = 0;

            if(flag == 1)
                System.out.println("yes");
            else
                System.out.println("no");

            // 초기화
            str = br.readLine();
            flag = 1;
            while (!stack.isEmpty())
                stack.pop();

        }
    }
}
