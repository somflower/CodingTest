package Part1.Ch04.BOJ11005;

import javax.imageio.IIOException;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ11005 {
    public static void makeNtoB(int N, int B, char[] Bformation){

        if(N < B){
            System.out.print(Bformation[N % B]);
            return;
        }
        else{
            makeNtoB(N / B, B, Bformation); // 10 2 -> 5 -> 2 -> 1 -> 0
            System.out.print(Bformation[N % B]);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, B, i;
        String str;
        StringTokenizer st;

        str = br.readLine();
        st = new StringTokenizer(str);

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        // 진법 표만들기, 최대 36진법이니까.. 36칸이 필요(0~35)
        char[] Bformation = {'0', '1', '2', '3', '4', '5',
                            '6', '7', '8', '9', 'A', 'B',
                            'C', 'D', 'E', 'F', 'G', 'H',
                            'I', 'J', 'K', 'L', 'M', 'N',
                            'O', 'P', 'Q', 'R', 'S', 'T',
                            'U', 'V', 'W', 'X', 'Y', 'Z'};

        // 진법 idx 저장 배열
        //int[] NtoBidx = new int[30];

        makeNtoB(N, B, Bformation);
    }
}
