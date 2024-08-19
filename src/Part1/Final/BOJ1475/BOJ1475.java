package Part1.Final.BOJ1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[10];
        int k, i, max = 0;

        String str = br.readLine();
        for(i=0;i<str.length();i++){
            k = Integer.parseInt(str.charAt(i) + "");
            k = (k == 6) ? 9 : k;
            numbers[k]++;
        }

        for(i=0;i<9;i++)
            max = Math.max(numbers[i], max);

        if(numbers[9] > 0)
            System.out.println(Math.max(max, numbers[9] / 2 + numbers[9] % 2));
        else
            System.out.println(max);
    }
}
