package Ch03;
import java.util.Scanner;

public class Ex36BreakExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.print(">>");
            String text = scanner.nextLine();
            if(text.equals("exit")) {
                break;
            }
            System.out.println("종료합니다...");
            scanner.close();
        }
    }
}
