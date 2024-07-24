package Part1.Ch03.BOJ3273;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3273 {
    // count sort
    // 00:57:42

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n, x, i, result = 0;
        String str;
        StringTokenizer st;

        n = Integer.parseInt(bf.readLine());

        int[] cArr = new int[1000001];

        // count sort 배열 만들기
        str = bf.readLine();
        st = new StringTokenizer(str);
        for(i=0;i<n;i++){
            cArr[Integer.parseInt(st.nextToken())]++;
        }

        x = Integer.parseInt(bf.readLine());

//        for(i=1;i<1000001;i++){
////            if((cArr[i] == 1) && (x - i > 0) && (x - i) < 1000001) // x - i의 범위가 중요
////                if(cArr[x - i] == 1)
////                    result++;
//
//            if((x - i > 0) && (x - i) < 1000001)
//                result += ((cArr[i] == 1) && (cArr[x - i] == 1)) ? 1 : 0;
//        }
        for(i = 1; i<=(x-1)/2;i++) {
            if (x - i <= 1000000)
                result += ((cArr[i] == 1) && (cArr[x - i] == 1)) ? 1 : 0;
        }
        bw.write(result + "");

//        if(result % 2 == 1)
//            bw.write(result / 2 + 1 + "");
//        else
//        bw.write(result / 2 + "");
        bw.flush();
    }
}
