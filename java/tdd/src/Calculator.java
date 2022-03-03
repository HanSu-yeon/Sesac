public class Calculator {
    public int sum(int num1, int num2){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return num1 + num2;
    }


    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.sum(1,2));
    }
}
