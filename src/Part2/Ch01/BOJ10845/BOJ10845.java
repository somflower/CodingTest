package Part2.Ch01.BOJ10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int N, i;
        String input;

        N = Integer.parseInt(br.readLine());

        for (i = 0; i < N; i++) {
            input = br.readLine();
            String[] cmd = input.split(" ");

            switch (cmd[0]) {
                case "push":
                    queue.add(Integer.parseInt(cmd[1]));
                    break;

                case "pop":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(queue.poll());
                    break;

                case "front":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(queue.peek());
                    break;

                case "back":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else {
                        System.out.println(((LinkedList<Integer>)queue).getLast());
                    }
                    break;

                case "size":
                    System.out.println(queue.size());
                    break;

                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
            }
        }
    }
}
