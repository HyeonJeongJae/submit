

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//public class baseballGame {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);

//        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
//         [[[1. 랜던 숫자 만들기]]]
// 랜덤 객체 생성
//        Random randomBall = new Random();

// 랜럼 객체의 시드 선언
// setSeed를 동일한 수로 지정해두면 랜덤으로 나오는 수가 규칙적으로 일정한 수를 발생시킴  ex) setSeed(3), setSeed(3) => 8 5 4 , 8 5 4
// 랜덤 난수가 나오기 위해 아래 코드로 랜덤 객체의 시드를 선언해줌
//        randomBall.setSeed(System.currentTimeMillis());

// 숫자 3개 뽑기
//        for (int i = 0; i < 3; i++) {
//            System.out.print(randomBall.nextInt(10));
//        }


// 숫자 중복 없애기, 비교를 해야 하는데 한계가 있음.

// 배열에 담아서 비교
//        int[] ball = new int[3];
//
//        for (int i = 0; i < 3; i++) {
//            // 랜던 숫자 ball { 0, 8, 8 }
//            ball[i] = randomBall.nextInt(10);
//
//            for (int j = 0; j < i; j++) {
//                // ball[0] == ball {0 , 1 , 2} 같으면 i를 감소해 반복문을 다시 돌게함.
//                if (ball[i] == ball[j]) {
//                    i--;
//                }
//            }
//        }
// 출력을 위한 반복문
//        for (int k = 0; k < 3; k++) {
//            System.out.print(ball[k]);
//        }


//        [[[2. 한자리 숫자에 대해 볼, 스트라이크 판단 하는 부분 구현]]]

//        char s = 'S';
//        char b = 'B';
//        랜던 숫자가 3 5 7 일때
//        사용자 입력 5 2 4 로 했을시  같은 숫자가 1개  위치 0개  1B0S 로 출력
//        ball[0] = 3;
//        ball[1] = 5;
//        ball[2] = 7;


//        3자리 수를 입력하는데 배열에 담긴 수를 비교하려면??
//        입력받은 숫자를 배열에 담고. 각 배열끼리 비교하기


//      입력받은 문자열 숫자를 문자형 배열로 바꾸고
//        String str = sc.nextLine();
//        char[] inputNums = str.toCharArray();
//
//        int[] number = new int[3];


//      문자형 배열을 인트형 배열로 옮기는 과정
//        for (int i = 0; i < inputNums.length; i++) {
//            number[i] = inputNums[i]-48;
//        }
//
//        for (int i = 0; i < 3; i++){
//            System.out.print(number[i]);
//        }


//        입력받은 숫자와 랜덤숫자 비교
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (listNum.get(i) == ball[j]) {
//                    if (i == j) {
//                        s++;
//                    } else {
//                        b++;
//                    }
//                }
//            }

public class Week1JJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        Random randomBall = new Random();
        randomBall.setSeed(System.currentTimeMillis());


        int[] ball = new int[3];

        // 랜덤 숫자 생성
        for (int i = 0; i < 3; i++) {
            ball[i] = randomBall.nextInt(10);
            for (int j = 0; j < i; j++) {
                if (ball[i] == ball[j]) {
                    i--;
                }
            }
        }

        // 틀렸을 경우 반복 시도
        int tryNum = 1;
        boolean escape = true;
        while (escape) {

            System.out.print(tryNum + "번째 시도 : ");

            // 사용자 입력 숫자
            String str = sc.nextLine();
            char[] inputNums = str.toCharArray();
            List<Integer> listNum = new ArrayList<>();

            for (int i = 0; i < inputNums.length; i++) {
                listNum.add(inputNums[i] - 48);
            }

            // 입력 숫자와 랜덤 숫자 비교
            int s = 0;
            int b = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (listNum.get(i) == ball[j]) {
                        if (i == j) {
                            s++;
                        } else {
                            b++;
                        }
                    }
                }
            }

            // 출력 구문
            if (s == 3) {
                escape = false;
                System.out.println("3S");
                System.out.println(tryNum + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
            } else {
                System.out.println(b + "B" + s + "S");
            }
            tryNum++;
        }

    }
}