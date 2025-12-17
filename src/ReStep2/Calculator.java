package ReStep2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // 속성
    int num1;
    int num2;
    char op;

    // 결과값 저장하기
    private final List<Integer> history = new ArrayList<>();

    // 생성자 : 필드에서 입력받아 수행 (자동 실행)
    public Calculator() {
    }

    // 메서드 (기능) 사칙연산 계산
    public int calculate() {

        int result;

        if (op == '+') {
            result = num1 + num2;
        } else if (op == '-') {
            result = num1 - num2;
        } else if (op == '*') {
            result = num1 * num2;
        } else if (op == '/') {
            if (num2 == 0) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            }
            result = num1 / num2;
        } else {
                System.out.println("잘못된 연산자입니다.");
                return 0;
            }

        // 결과값 숫자만 리스트에 저장
        history.add(result);
        return result;
    }

    // getter 로 저장값 호출부
    public List<Integer> getHistory() {
        return history;
    }

    // 가장 먼저 저장된 결과 삭제 메서드
    public Integer removeFirstHistory() {
        if (history.isEmpty()) {
            return null;
        }
        return history.remove(0);
    }
}