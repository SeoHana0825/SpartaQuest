package ReStep3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator calculator = new ArithmeticCalculator();


        System.out.println("=== 계산기를 시작합니다 ===");

        while (true) {

            System.out.println("첫 번째 숫자: ");
            double num1 = sc.nextDouble();
            if (num1 < 0) {
                System.out.println("0을 포함한 양수만 가능합니다.");
                continue;
            }

            System.out.println("두 번째 숫자: ");
            double num2 = sc.nextDouble();
            if (num2 < 0) {
                System.out.println("0을 포함한 양수만 가능합니다.");
                continue;
            }

            System.out.println("사칙연산 기호를 입력해주세요");
            char op = sc.next().charAt(0);

            // 람다식 클래스에서 계산하기
            OperatorType operator = OperatorType.from(op);
            double result = calculator.calculate(num1, num2, operator);
            System.out.println("결과: " + result);

            // 저장값 (history) 불러오기
            System.out.println("저장값: " + calculator.getHistory());

            // 가장 먼저 저장된 값 삭제하기
            System.out.println("가장 먼저 저장된 값을 삭제하시겠습니까? 원하시면 ' yes ' 를 입력해주세요");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("yes")) {
                Double removed = calculator.removeFirstHistory();

                System.out.println("현재 저장값: " + calculator.getHistory());
            }

            // Scanner에서 입력받은 기준 값 중에서 가장 큰 값 출력 (람다&스트림 활용)
            System.out.println("입력한 값들 중 큰 결과를 조회하시겠습니까?");
            String answer2 = sc.next();

            if (answer2.equalsIgnoreCase("yes")) {
                System.out.println("기준 값을 입력하세요");
                double max = sc.nextDouble();
                System.out.println("기준보다 큰 결과: " + calculator.getGetMaximum(max));
            }


            // "exit" 을 입력하면 종료
            System.out.println("종료를 원하시면 'exit' 을 입력해주세요.");
            String exit = sc.next();

            // 대/소문자 구별없이 사용
            if (exit.equalsIgnoreCase("exit")) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

        } sc.close();
    }
}
