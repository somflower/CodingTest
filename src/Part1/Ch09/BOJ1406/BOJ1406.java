package Part1.Ch09.BOJ1406;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;


public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<Character> list = new LinkedList<>();
        int M, i;
        String input;
        ListIterator<Character> iterator;

        // LinkedList 초기화
        String str = br.readLine();
        for(i=0;i<str.length();i++)
            list.add(str.charAt(i));

        M = Integer.parseInt(br.readLine());

        //시작점은 list의 마지막
        iterator = list.listIterator(list.size());

        for(i=0;i<M;i++){
            input = br.readLine();

            switch (input.charAt(0)){
                case 'L': // 왼쪽으로 한 칸
                    if(iterator.hasPrevious()) // 앞이 있으면 이동
                        iterator.previous();
                    break;

                case 'D': // 오른쪽으로 한 칸
                    if(iterator.hasNext()) // 뒤가 있으면 이동
                        iterator.next();
                    break;

                case 'B': // 앞 글자 삭제
                    if(iterator.hasPrevious()){ // 앞이 있는지 확인
                        iterator.previous(); // 앞으로 이동 후
                        iterator.remove(); // 삭제시킴
                    }
                    break;

                case 'P':
                    iterator.add(input.charAt(2)); // 글자 넣기
                    break;
            }
        }

        iterator = list.listIterator(); // 처음으로 지정
        while(iterator.hasNext())
            bw.write(iterator.next());
        bw.flush();
        bw.close();
    }
}
