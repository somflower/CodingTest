package Part1.Ch09.BOJ1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1158 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int N, K, i;

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // arrayList 초기화
        for (i=1;i<=N;i++)
            list.add(i);

        System.out.print("<");
        i = 0;
        while(!list.isEmpty()){
//            System.out.println("i : " + i);

            i += (K - 1);
            if(i < list.size()){
                System.out.print(list.remove(i));
            }
            else{
                i %= list.size();
                System.out.print(list.remove(i));
            }

            if(list.size() >= 1)
                System.out.print(", ");
        }
        System.out.print(">");
    }
}
