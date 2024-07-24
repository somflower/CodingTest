package Part1.Ch02.BOJ10158;

import javax.swing.plaf.ColorUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10158 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String size, current;
        String[] sizeStr, currentStr;
        int w, h, p, q, hour, resultP, resultQ;

        size = bf.readLine();
        current = bf.readLine();
        sizeStr = size.split(" ");
        currentStr = current.split(" ");

        w = Integer.parseInt(sizeStr[0]);
        h = Integer.parseInt(sizeStr[1]);
        p = Integer.parseInt(currentStr[0]);
        q = Integer.parseInt(currentStr[1]);
        hour = Integer.parseInt(bf.readLine());

        resultP = (p + hour) % (2 * w);
        resultQ = (q + hour) % (2 * h);

        if(resultP > w)
            resultP = w - (resultP - w);
        if(resultQ > h)
            resultQ = h - (resultQ - h);
        /*
        resultP = p + hour;
        resultQ = q + hour;

        while((resultP<0||resultP>w)||(resultQ<0||resultQ>h)){
            if(resultP > w)
                resultP = w - (resultP - w);
            if(resultQ > h)
                resultQ = h - (resultQ - h);
            if(resultQ < 0)
                resultQ *= -1;
            if(resultP < 0)
                resultP *= -1;
        }
         */

        System.out.println(resultP + " " + resultQ);
    }
}
