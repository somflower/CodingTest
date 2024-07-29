package Part1.Ch05.BOJ1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class BOJ1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, i;
        String bookTitle;
        Map<String, Integer> books = new TreeMap<>();

        N = Integer.parseInt(br.readLine());

        for(i=0;i<N;i++){
            bookTitle = br.readLine();

            //새로운 책인지 있던 책인지 확인하기
            if(!books.containsKey(bookTitle))
                books.put(bookTitle, 1); // 새로운 책일때
            else
                books.put(bookTitle, books.get(bookTitle) + 1); // 등록된 책일때
        }

        Map.Entry<String, Integer> maxEntry = Collections.max(books.entrySet(), Map.Entry.comparingByValue());

        System.out.println(maxEntry.getKey());

//        books.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
