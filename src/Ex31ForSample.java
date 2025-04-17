public class Ex31ForSample {
    public static void main(String[] args) {
        int i, sum = 0;

        for(i = 1; i <= 10; i++) {
            sum += i;
            System.out.print(i);

            if(i <= 9) // 1~9까지는 '+' 출력
                System.out.print("+");
            else {  // i가 10인 경우
                System.out.print("=");
                System.out.print(sum);
            }
        }
    }
}