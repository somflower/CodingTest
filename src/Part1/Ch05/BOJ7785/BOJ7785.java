package Part1.Ch05.BOJ7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, i;
        String str, name, log;
        StringTokenizer st;
        Map<String, String> members = new TreeMap<>(Comparator.reverseOrder());

        n = Integer.parseInt(br.readLine());

        for(i=0;i<n;i++){
            str = br.readLine();
            st = new StringTokenizer(str);

            name = st.nextToken();
            log = st.nextToken();

            members.put(name, log);
        }

        members.forEach((key, value) -> {
            if(value.equals("enter"))
                System.out.println(key);
        });

    }
}
