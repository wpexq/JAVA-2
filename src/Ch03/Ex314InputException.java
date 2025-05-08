package Ch03;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex314InputException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 3개를 입력");
        int sum = 0, n = 0;
        for(int i = 0; i < 3; i++) {
            System.out.print(i+">>");
            try {
                n = scanner.nextInt();
            }
            catch(InputMismatchException e) {
                System.out.println("정수가 아님. 다시 입력");
                scanner.next();
                i--;
                continue;
            }
            sum += n;
        }
        System.out.println("합은 " + sum);
        scanner.close();
        
    }
}
