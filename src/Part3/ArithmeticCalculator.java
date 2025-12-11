package Part3;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
        // 1. 속성 - 변수 선언으로 표현 할 수 있음

        // 2. 생성자

        // 3. 기능 (메서드)
        private OperatorType operatorType;
        private List<Integer> history = new ArrayList<>();

        public int calculate(int num1, int num2) {

            int result = 0;

            switch (operatorType) {
                case PLUS:
                    result = num1 + num2;
                    break;
                case MINUS:
                    result = num1 - num2;
                    break;
                case MULTIPLY:
                    result = num1 * num2;
                    break;
                case DIVIDE:
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모 (두번째 정수)에 0이 입력될 수 없습니다.");
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("지원하지 않는 연산자입니다.");
                    break;
            }

            history.add(result);
            return result;
        }
        // 게터
        public List<Integer> getHistory() {
            return this.history;
        }

        // 세터
        public void setOperator(OperatorType operator) {
            this.operatorType = operator;
        }

        // 데이터 삭제
        public void removeResult() {
            this.history.clear();
        }
    }