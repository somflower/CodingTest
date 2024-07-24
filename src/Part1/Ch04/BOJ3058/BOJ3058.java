package Part1.Ch04.BOJ3058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T, i, j, min = 100, sum = 0, tmp;
        String str;
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(i=0;i<T;i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            for (j = 0; j < 7; j++) {
                tmp = Integer.parseInt(st.nextToken());
                if (tmp % 2 == 0) {
                    sum += tmp;
                    if (tmp < min)
                        min = tmp;
                }
            }
            System.out.println(sum + " " + min);
            sum = 0;
            min = 100;
        }
    }
}
