package Part3;

import Part2.Calculator;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ArithmeticCalculator calculator = new ArithmeticCalculator();

        Scanner scanner = new Scanner(System.in);

        List<Integer> history = calculator.getHistory();

        while (true) {

            int num1,num2;

            try {
                System.out.println("첫 번째 숫자를 입력해주세요: ");
                num1 = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
                continue;
            }
            System.out.println("사칙연산 기호를 입력해주세요 (+,-,*,/): ");
            char operator = scanner.next().charAt(0);
            OperatorType type = OperatorType.from(opType);
            calculator.setOperator(type);

            try {
                System.out.println("두 번째 숫자를 입력해주세요: ");
                num2 = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
                continue;
            }
            int result = calculator.calculate(num1, num2);

            System.out.println("결과: " + result);

            calculator.setOperator(OperatorType.PLUS);
            System.out.println("history: " + history);

            System.out.println("더 계산하시겠습니까? (exit 입력)");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("exit")) break;
        }
        System.out.println("계산기를 종료합니다.");
        scanner.close();
    }
}
