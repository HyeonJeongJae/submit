import java.util.Scanner;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;

/*
* S팀 13조 장수주
* 야구게임
* */

public class Week1SJ {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

//        Set<Integer> hashNumbers = new HashSet<>(); // 중복이 안되는 HashSet를 사용해 난수 생성, 순서무시
        Set<Integer> hashNumbers = new LinkedHashSet<>(); // 순서 영향 있음
        System.out.print("난수 for문 확인 : ");
        while (hashNumbers.size() < 3) { // 숫자 3자리가 완성될때까지 반복함
            int number = random.nextInt(9); // 0에서 9 사이의 난수 생성
            System.out.print(number); // 생성한 난수 확인 테스트용
            hashNumbers.add(number); // HashSet라서 중복되면 add가 안됨
        }
        System.out.println();

        int[] creatNum = new int[3];
        Object[] test = hashNumbers.toArray(); // 배열로 변경하면서 숫자가 정렬되는것같음.. why? HashSet은 데이터의 순서를 보장하지않음
        for (int i=0; i<test.length; i++) {
            creatNum[i] = (int)test[i];
        }

        System.out.print("최종 생성된 난수 : ");
        for(int i=0; i<creatNum.length; i++) {
            System.out.print(creatNum[i] + "");
        }
        System.out.println();

//        // 일반 for문으로 난수 생성
//        int[] creatNum = new int[3];
//        // 난수생성 for
//        for(int i=0; i<creatNum.length; i++) {
//            creatNum[i] = random.nextInt(9)+1;
//            for(int j=0; j<i; j++) {
//                if(creatNum[i] == creatNum[j]) {
//                    i--;
//                    break;
//                }
//            }
//        }
//        // 난수생성 표시 for (테스트용)
//        for(int i=0; i<creatNum.length; i++) {
//            System.out.print(creatNum[i] + "");
//        }

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        int createRandomCnt = 0; // 랜덤생성 횟수 체크
        while(true) { // 정답일때까지 계속 반복함
            createRandomCnt++; // 랜덤 횟수 추가

            System.out.print(createRandomCnt + "번째 시도 : ");

            int inputNumber = scanner.nextInt(); // 숫자 입력받음
            String inputNumStr = Integer.toString(inputNumber); // 입력받은 숫자를 문자열로 변경

            // 유저가 입력한 값을 저장할 배열
            int[] userInput = new int[3];
            // 각 문자를 배열에 저장
            for (int i = 0; i < userInput.length; i++) {
                userInput[i] = Character.getNumericValue(inputNumStr.charAt(i));
            }

            // 볼, 스트라이크 개수 체크
            int ball    = 0;
            int strike  = 0;
            for(int i = 0; i < creatNum.length; i++) {
                if(creatNum[i] == userInput[i]) { // 스트라이크 (숫자, 위치 모두 동일함)
                    strike++;
                } else {
                    for(int j = 0; j < userInput.length; j++) {
                        if(creatNum[i] == userInput[j]) { // 볼 (위치는 다르나, 숫자는 포함되어있음)
                            ball++;
                            break;
                        }
                    }
                }
            }
            System.out.println("결과: " + ball + "B" + strike + "S");

            if(strike == 3) { // 정답을 맞추면 게임 종료
                System.out.println(createRandomCnt + "번만에 정답입니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }
}