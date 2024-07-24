package Part1.Ch01.BOJ13223;

import java.util.Scanner;

public class BOJ13223 {
    public static void main(String[] args) {
        String start, end;
        int sHour, sMinute, sSecond, eHour, eMinute, eSecond;
        Scanner sc = new Scanner(System.in);
        start = sc.next();
        end = sc.next();

        // 1. ':'를 기준으로 시간, 분, 초를 쪼개기
        // 1-1) 시,분,초가 정해져있으므로 직관적으로 계산
        sHour = (start.charAt(0) - '0') * 10 + (start.charAt(1) - '0');
        sMinute = (start.charAt(3) - '0') * 10 + (start.charAt(4) - '0');
        sSecond = (start.charAt(6) - '0') * 10 + (start.charAt(7) - '0');
        eHour = (end.charAt(0) - '0') * 10 + (end.charAt(1) - '0');
        eMinute = (end.charAt(3) - '0') * 10 + (end.charAt(4) - '0');
        eSecond = (end.charAt(6) - '0') * 10 + (end.charAt(7) - '0');

        // 1-2) substring 이용, 결과가 string이므로 int로 변환해준다.
        sHour = Integer.parseInt(start.substring(0,2));
        sMinute = Integer.parseInt(start.substring(3,5));
        sSecond = Integer.parseInt(start.substring(6,8));
        eHour = Integer.parseInt(end.substring(0,2));
        eMinute = Integer.parseInt(end.substring(3,5));
        eSecond = Integer.parseInt(end.substring(6,8));

        // 1-3) split 이용, 마찬가지로 int로 변환
        String[] sTime = start.split(":");
        String[] eTime = end.split(":");
        sHour = Integer.parseInt(sTime[0]);
        sMinute = Integer.parseInt(sTime[1]);
        sSecond = Integer.parseInt(sTime[2]);
        eHour = Integer.parseInt(eTime[0]);
        eMinute = Integer.parseInt(eTime[1]);
        eSecond = Integer.parseInt(eTime[2]);

        // 2. 시간, 분, 초의 차이를 계산
        // 2-1) 각각 뺄셈하고 음수인 경우에 더 큰 단위에서 내림한다.
        int needSecond, needMinute, needHour;
        needSecond = eSecond - sSecond;
        needMinute = eMinute - sMinute;
        needHour = eHour - sHour;

        if(needSecond < 0) {
            needSecond += 60;
            needMinute--;
        }
        if(needMinute < 0) {
            needMinute += 60;
            needHour--;
        }
        if(needHour <= 0)
            needHour += 24;

        // 2-2) 작은 단위(초)로 바꾸고 한 번에 계산
        int sSecondAmount = sHour * 3600 + sMinute * 60 + sSecond;
        int eSecondAmount = eHour * 3600 + eMinute * 60 + eSecond;
        int needSecondAmount = eSecondAmount - sSecondAmount;
        if(needSecondAmount <= 0)
            needSecondAmount += 24*3600;

        needHour = needSecondAmount / 3600;
        needMinute = (needSecondAmount % 3600) / 60;
        needSecond = needSecondAmount % 60;

        // 3. 출력하기
        System.out.printf("%02d:%02d:%02d", needHour, needMinute, needSecond);

    }
    /*public static int AtoI(String str){
        int i = 0, num = 0;
        char ch;
        while(i<str.length()){
            ch = str.charAt(i);
            if(ch>='0'&&ch<='9'){
                num = num*10 + (ch - '0');
            }
            i++;
        }
        return num;
    }
    public static int calcTime(int sTime, int eTime){
        int result = 0, s, e, i, flag = 0, comma = 1;

        //System.out.println(sTime);
        //System.out.println(eTime);

        if(eTime <= sTime)
            eTime += 240000;

        for(i=0;i<3;i++){
            // 두자리씩 비교
            s = sTime % 100;
            sTime = sTime / 100;
            e = eTime % 100;
            eTime = eTime / 100;
            if(flag == 1){
                e -= 1;
                flag = 0;
            }
            if(s > e){
                e += 60;
                flag = 1;
            }
            result += (e - s) * comma;
            comma *= 100;
        }
        //System.out.println(result);
        return result;
    }
    public static String addZero(String str){
        if(str.length() == 1)
            str = "0"+ str;
        return str;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String start, end, result, hh, mm, ss;
        int sTime, eTime, value;

        start = sc.next();
        end = sc.next();

        sTime = AtoI(start);
        eTime = AtoI(end);
        value = calcTime(sTime, eTime);

        ss = (value % 100) + "";
        mm = ((value % 10000)/100) + "";
        hh = (value/10000) + "";

        ss = addZero(ss);
        mm = addZero(mm);
        hh = addZero(hh);

        result = hh + ":" + mm + ":" + ss;
        System.out.println(result);
    }*/
}
