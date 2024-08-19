package Part1.Ch08.BOJ17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17609 {
    public static int isPalindrome(char[]arr, int left, int right){
        while(left < right){
            if(arr[left] != arr[right])
                return 0;
            left++;
            right--;
        }
        return 1;
    }

    public static int checkPalindrome(char[] arr){
        int left = 0, right = arr.length - 1, result = 0;

        while(left < right ) {
            if(arr[left] != arr[right]){
                if((isPalindrome(arr, left + 1, right) == 1)
                       || (isPalindrome(arr, left, right - 1) == 1))
                    result = 1;
                else
                    result = 2;
                break;
            }
            else{
                left++;
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T, i;
        String str;

        T = Integer.parseInt(br.readLine());

        for(i=0;i<T;i++){
            str = br.readLine();
            System.out.println(checkPalindrome(str.toCharArray()));
        }

//        for(i=0;i<T;i++){
//            str = br.readLine();
//            result = 2;
//            // 1. palindrome인지 확인
//            if(checkPalindrome(str.toCharArray(), str.length()) == 1)
//                result = 0;
//            else {
//
//                // 2. 1개 빼고 palindrome인지 확인
//                for(k=0;k<str.length();k++){
//                    subStr = "";
//                    for(j=0;j<str.length();j++){
//                        if(k != j)
//                            subStr += str.charAt(j);
//                    }
////                    System.out.println(subStr);
//                    if(checkPalindrome(subStr.toCharArray(), subStr.length()) == 1) {
//                        result = 1;
//                        break;
//                    }
//
//                }
//
//            }
//            System.out.println(result);
//        }
    }
}
