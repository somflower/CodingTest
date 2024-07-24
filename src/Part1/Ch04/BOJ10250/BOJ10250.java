package Part1.Ch04.BOJ10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10250 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T, H, W, N, i, j;
        String str;
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(i=0;i<T;i++){
            str = br.readLine();
            st = new StringTokenizer(str);

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            for(j=0;N>H;j++){
                N -= H;
            }
            if(j<9)
                System.out.println(N+"0"+(j + 1));
            else
                System.out.println(N+""+(j + 1));
        }


    }
}
// 6 4 -> 402
// 30 30 12 -> 1203
