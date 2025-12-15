package ReStep2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        // 반복문 시작
        while (true) {
            System.out.println("첫번째 숫자를 입력해주세요: ");
            int num1 = sc.nextInt();
               if (num1 < 0) {
                System.out.println("0을 포함한 양수만 가능합니다");
                continue;
               }

            System.out.println("두번째 숫자를 입력해주세요: ");
            int num2 = sc.nextInt();
                if (num2 < 0) {
                    System.out.println("0을 포함한 양수만 가능합니다.");
                    continue;
                }

            System.out.println("사칙연산 기호를 입력해주세요: ");
            char op = sc.next().charAt(0);

            // setter 불러오기
            calculator.setNum1(num1);
            calculator.setNum2(num2);
            calculator.setOp(op);

            // 계산하기
            int result = calculator.calculate();
            System.out.println("결과: " + result);

            // 저장값 (history) 불러오기
            System.out.println("저장값: " + calculator.getHistory());

            // 가장 먼저 저장된 값 삭제하기
            System.out.println("가장 먼저 저장된 값을 삭제하시겠습니까? (yes)");
            String answer = sc.next();
               if ("yes".equals(answer)) {
                  calculator.removeFirstHistory();
                  System.out.println("현재 저장값: " + calculator.getHistory());
               }

            // "exit"을 입력하면 종료
            System.out.println("종료를 원하시면 'exit' 을 입력 해주세요)");
            String exit = sc.next();

            if (exit.equals("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
        } sc.close();
    }
}
