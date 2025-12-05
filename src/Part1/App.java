package Part1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Scanner를 사용하여 양의 정수 2개(0 포함)를 전달받을 수 있습니다.

        while (true) {

            int num1, num2;

            try {
                System.out.println("첫 번째 숫자를 입력해주세요: ");
                // Scanner를 사용하여 양의 정수는 각각 하나씩 전달 받습니다.
                num1 = scanner.nextInt();
                // 양의 정수는 적합한 타입으로 선언한 변수에 저장합니다.
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
                continue;
            }

            System.out.println("사칙연산 기호를 입력해주세요 (+,-,*,/): ");
            // Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
            char op = scanner.next().charAt(0);
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.

            try {
                System.out.println("두 번째 숫자를 입력해주세요: ");
                // Scanner를 사용하여 양의 정수는 각각 하나씩 전달 받습니다.
                num2 = scanner.nextInt();
                // 양의 정수는 적합한 타입으로 선언한 변수에 저장합니다.
                // 연산 오류가 발생할 경우 해당 오류에 대한 내용을 정제하여 출력합니다.
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
                continue;
            }
            int result = 0;

            // if: 간단하고 적은 수의 가정문일 때 사용하기 용이
            // switch: if에 비해 간단한 수식으로 많은 가정이 있을 때 사용하기 용이해서 선택
            switch (op) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/': {
                    if (op == '/' && num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모 (두번째 정수)에 0이 입력될 수 없습니다.");
                    } else {

                        result = num1 / num2;
                    } break;
                }
                default:
                    System.out.println("지원하지 않는 연산자입니다.");
                    break;
            }
            // 사칙연산 기호에 맞는 연산자를 사용하여 연산을 진행합니다.
            System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? (exit 입력)");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("exit")) break;
            }
            System.out.println("계산기를 종료합니다.");
            scanner.close();
        }

    }