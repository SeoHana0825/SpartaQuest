package ReStep3;

public enum OperatorType {

    // enum, 람다식 익명 클래스를 변수에 담아 전달
    ADD('+') {
        @Override
        public double apply(double num1, double num2) {
            return num1 + num2;
        }
    }, MINUS('-') {
        @Override
        public double apply(double num1, double num2) {
            return num1 - num2;
        }

    }, MULTIPLY('*') {
        @Override
        public double apply(double num1, double num2) {
            return num1 * num2;
        }

    }, DIVIDED('/') {
        @Override
        public double apply(double num1, double num2) {
            if (num2 == 0) {
                throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
            }
            return num1 / num2;
        }
    };

    // enum symbol 선언
    private final char symbol;

    private OperatorType(char symbol) {
        this.symbol = symbol;
    }

    // 람다 apply 메서드 선언
    public abstract double apply(double num1, double num2);

    // 예외처리 "잘못된 연산자입니다."
    public static OperatorType from(char symbol) {
        for (OperatorType op : OperatorType.values()) {
            if (op.symbol == symbol) {
                return op;
            }
        } throw new IllegalArgumentException("잘못된 연산자입니다.");
    }
}

