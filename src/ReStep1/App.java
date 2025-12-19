package ReStep1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // 양의 정수 입력받기 (0 포함)
        Scanner sc = new Scanner(System.in);

        while (true) {
            // 첫번째 숫자 입력
            System.out.println("첫번째 숫자를 입력해주세요: ");
            int num1 = sc.nextInt();

            if (num1 < 0) {
                System.out.println("0을 포함한 양수만 입력가능합니다.");
                continue;
            }

            // 두번째 숫자 입력
            System.out.println("두번째 숫자를 입력해주세요: ");
            int num2 = sc.nextInt();

            if (num2 < 0) {
                System.out.println("0을 포함한 양수만 입력가능합니다.");
                continue;
            }

            // 사칙연산 기호 입력받기
            System.out.println("사칙연산 기호를 입력해주세요: ");
            char op = sc.next().charAt(0);

            // 결과 변수
            int result;

            // if문 활용
            if (op == '+')
                result = num1 + num2;
            else if (op == '-')
                result = num1 - num2;
            else if (op == '*')
                result = num1 * num2;
            else if (op == '/') {
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    continue;
                    // continue 를 사용해 완전 종료되지 않고 처음으로 돌아가기
                }
                result = num1 / num2;
            } else {
                System.out.println("잘못된 연산자입니다."); // 연산자가 아닌 다른 문자가 들어갔을 때 예외 상황
                continue;
            }
            System.out.println("결과: " + result);

            // exit 입력 시 종료, 이외 다른 문자 시 계속 진행
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
           String exit = sc.next();

            if (exit.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                sc.close();
            }

        }
    }
}
