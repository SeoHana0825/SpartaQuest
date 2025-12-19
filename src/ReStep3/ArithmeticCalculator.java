package ReStep3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator {

    // 결과값 저장 선언
    private final List<Double> history = new ArrayList<>();

    // 계산이 된 enum, 람다 불러와서 저장
    public double calculate(double a, double b, OperatorType operator) {
        double result = operator.apply(a, b);
        history.add(result);
        return result;

    }

    // getter 로 저장값 호출
    public List<Double> getHistory() {
        return history;
    }

    // 가장 먼저 저장된 결과 삭제
    public Double removeFirstHistory() {
        if (history.isEmpty()) {
            return null;
        }
        return history.remove(0);
    }

    // Scanner에서 입력받은 기준 값 중에서 가장 큰 값 출력 (람다&스트림 활용)
    public List<Double> getGetMaximum(Double max) {
        return history.stream() // 데이터 흐름 준비
                .filter(num -> num > max)  // 중간 연산 등록 - filter 요소 고르기 : 입력 값 중 가장 큰 값
                .collect(Collectors.toList()); // 최종 연산 등록

    }
}
