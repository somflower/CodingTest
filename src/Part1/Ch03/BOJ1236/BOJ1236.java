package Part1.Ch03.BOJ1236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ1236 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);
        int row, col, i, j;
        String [][] arr;
        String str;

        str = bf.readLine(); // 한 줄 읽기
        StringTokenizer st = new StringTokenizer(str); // 공백으로 분리됨
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
//        row = sc.nextInt();
//        col = sc.nextInt();
        arr = new String[row][col];

        // 입력 받기
        for(i=0;i<row;i++){
            str = bf.readLine(); // 한 줄 읽기
            for (j=0;j<col;j++){
                arr[i][j] = str.charAt(j)+""; // char -> String 변환
                // arr[i][j] = sc.next();
            }
        }

        // 행&열 배열 만들고 병사 유무 적기
        int [] countRow = new int[row];
        int [] countCol = new int[col];

        // 행 병사 유무 확인
        for(i=0;i<row;i++){
            for(j=0;j<col;j++){
                if(arr[i][j].equals("X")) {
                    countRow[i] = 1;
                    break;
                }
                countRow[i] = 0;
            }
        }

        // 열 병사 유무 확인
        for(j=0;j<col;j++){
            for(i=0;i<row;i++){
                if(arr[i][j].equals("X")) {
                    countCol[j] = 1;
                    break;
                }
                countCol[j] = 0;
            }
        }

        // 0 개수 세기
        int countZeroRow = 0;
        int countZeroCol = 0;

        for(i=0;i<row;i++)
            if(countRow[i] == 0)
                countZeroRow++;
        for(i=0;i<col;i++)
            if(countCol[i] == 0)
                countZeroCol++;

        // 두어야 할 병사의 수
        System.out.println(Math.max(countZeroRow, countZeroCol));
//        if(countZeroRow > countZeroCol)
//            System.out.println(countZeroRow);
//        else
//            System.out.println(countZeroCol);

        // 출력
//        for(i=0;i<row;i++){
//            for (j = 0; j < col; j++)
//                System.out.print(arr[i][j]);
//            System.out.println();
//        }
//
//        for(i=0;i<row;i++)
//            System.out.print(countRow[i]);
//        System.out.println();
//        for(i=0;i<col;i++)
//            System.out.print(countCol[i]);
//
//        System.out.println();
//        System.out.println("행 0의 개수: " + countZeroRow);
//        System.out.println("열 0의 개수: " + countZeroCol);
    }

}
