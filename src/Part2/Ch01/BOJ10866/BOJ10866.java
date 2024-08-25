package Part2.Ch01.BOJ10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();
        int N, i;
        String input;

        N = Integer.parseInt(br.readLine());

        for (i = 0; i < N; i++) {
            input = br.readLine();
            String[] cmd = input.split(" ");

            switch (cmd[0]) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(cmd[1]));
                    break;

                case "push_back":
                    deque.add(Integer.parseInt(cmd[1]));
                    break;

                case "pop_front":
                    if (deque.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(deque.poll());
                    break;

                case "pop_back":
                    if (deque.isEmpty())
                        System.out.println(-1);
                    else{

                        System.out.println(deque.pollLast());
                    }
                    break;

                case "size":
                    System.out.println(deque.size());
                    break;

                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;

                case "front":
                    if (deque.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(deque.peek());
                    break;

                case "back":
                    if (deque.isEmpty())
                        System.out.println(-1);
                    else {
                        System.out.println(deque.getLast());
                    }
                    break;



            }
        }
    }
}
