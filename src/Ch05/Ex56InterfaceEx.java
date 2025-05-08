package Ch05;

interface PhoneInterface {
    final int TIMEOUT = 1000;
    void sendCall();    // 추상 메소드
    void recevieCall(); // 추상 메소드
    default void printLogo() {  // default 메소드
        System.out.println("** Phone **");
    }
}
class SamsungPhone implements PhoneInterface {
    // PhoneInterface의 모든 메소드 구현 
    @Override
    public void sendCall() {
        System.out.println("띠리리리링");
    }
    @Override
    public void recevieCall() {
        System.out.println("전화가 왔습니다");
    }
    // 메소드 추가 작성
    public void flash() { System.out.println("전화기에 불이 켜졌습니다");}
}
public class Ex56InterfaceEx { 
    public static void main(String[] args) {
        SamsungPhone phone = new SamsungPhone();
        phone.printLogo();
        phone.sendCall();
        phone.recevieCall();
        phone.flash();
    }
    
}
