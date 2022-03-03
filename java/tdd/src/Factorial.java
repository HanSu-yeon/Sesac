public class Factorial {
    public int factorial(int i) {
        if(i<0)
            throw new IllegalArgumentException("잘못된 입력입니다");

        if(i<2) return 1;
        return factorial(i-1)*i;
    }
}
