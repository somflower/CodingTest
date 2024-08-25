package Part2.Ch01.BOJ5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ5430 {
    public static void AC(String p, int n, String x) {
        int i, flag = 0, size;
        Deque<Integer> deque = new LinkedList<>();

        if (n > 0) {
            String[] xArr = x.replaceAll("[\\[\\]]", "").split(","); // 대괄호 빼고 숫자있는 String 배열 만들기
            for (i = 0; i < n; i++) {
                deque.add(Integer.parseInt(xArr[i]));
            }
        }

        for (i = 0; i < p.length(); i++) {
            switch (p.charAt(i)) {
                case 'R':
                    flag = flag == 0 ? 1 : 0;
                    break;

                case 'D':
                    if (deque.isEmpty()){
                        System.out.println("error");
                        return;
                    }
                    else{
                        if(flag == 1)
                            deque.pollLast();
                        else
                            deque.poll();
                    }
                    break;
            }
        }

        size = deque.size();
        System.out.print("[");
        for(i=1;i<size;i++){
            if(flag == 1)
                System.out.print(deque.pollLast()+",");
            else
                System.out.print(deque.pollFirst()+",");
        }
        if(size != 0)
            System.out.print(deque.poll());
        System.out.println("]");

    }

    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, T, n;
        String p, x;

        T = Integer.parseInt(br.readLine());

        for (i = 0; i < T; i++) {
            p = br.readLine();
            n = Integer.parseInt(br.readLine());
            x = br.readLine();
            AC(p, n, x);
        }
    }
}
