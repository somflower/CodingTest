package Part1.Ch08.BOJ2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4 3
1 3 5 6
3-1 -> 5-1 -> 5-3 -> 6-3
 */

public class BOJ2230 {
    public static int getMinusMin(int[] numbers, int M){
        int i = 0, j = 1, min = 2000000000, result;

        while(j<numbers.length){
            result = numbers[j] - numbers[i];
            if(result == M)
                return result;
            else if(result > M){
                min = Math.min(result, min);
                i++;
                if(j == i)
                    j++;
            }
            else
                j++;
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, i;
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];

        for(i=0;i<N;i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        System.out.println(getMinusMin(numbers, M));

    }
}
