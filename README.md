# 안지혜 202430113
## 5월 8일 (10주차)

### 추상 클래스
```java
- 추상 메소드
    - abstract로 선언된 메소드, 메소드의 코드는 없고 원형만 선언
    ex) abstract public String getName(); // 추상 메소드

        abstract public String fail() { return "Good Bye" }; // 추상 메소드 아님. 컴파일 오류

- 추상 클래스
    - 추상 메소드를 가지며, abstract로 선언된 클래스
    - 추상 메소드 없이, abstract로 선언한 클래스
 * 추상 클래스는 온전한 클래스가 아니기 때문에 인스턴스 생성 불가능!!

 - 추상 클래스 상속
    - 추상 클래스를 상속받으면 추상 클래스가 됨
    - 서브 클래스도 abstract로 선언해야 함
    ex) abstract class A { // 추상 클래스
            abstract public int add(int x, int y);  // 추상 메소드
        }
        abstract class B extends A {    // 추상 클래스
            public void show() { System.out.println("B"); }
        }
- 추상 클래스 구현
    - 서브 클래스에서 슈퍼 클래스의 추상 메소드 구현(오버라이딩)
    * 추상 클래스를 구현한 서브 클래스는 추상 클래스가 아님

- 추상 클래스의 목적   
    - 상속을 위한 슈퍼 클래스로 활용하는 것
    - 서브 클래스에서 추상 메소드 구현
    - 다형성 실현
```
---

### 인터페이스
- 클래스가 구현해야 할 메소드들이 선언되는 추상형
- interface 키워드로 선언 <br>
    ex) public interface Example {...}

- 인터페이스 구성 요소
    - 상수
        - public (public static final 생략)
    - 추상 메소드
        - public abstract 생략 가능
    - default 메소드 
        - 인터페이스에 코드가 작성된 메소드
        - 자동 상속
        - public 접근 지정만 허용. 생략 가능
    - private 메소드
        - 인터페이스 내에 메소드 코드가 작성되어야 함
        - 인터페이스 내에 있는 다른 메소드에 의해서만 호출 가능
    - static 메소드
        - public, private 모두 지정 가능. 생략하면 public
- 인터페이스의 객체 생성 불가
- 인터페이스 타입의 레퍼런스 변수 선언 가능

```java
- 인터페이스 간에 상속 가능
    - extends 키워드로 상속 선언
    ex) interface MobliePthoneInterface extends PhoneInterface {
        // 추상 메소드 추가
        void sendSMS();
        void receiveSMS();
    }
    ex) interface MusicPhoneInterface extends PhoneInterface. MP3Interface {...} // 인터페이스 다중 상속 가능
- 인터페이스 구현
    - implemnets 키워드 사용
    - 여러 개의 인터페이스 동시 구현 가능
```
---

### 패키지
- 3명이 분담하여 자바 응용프로그램을 개발하는 겨우, 동일한 이름의 클래스가 존재할 가능성이 있다 -> 합칠 때 오류 발생 가능성
    - 이름은 같지만 경로명이 달라 서로 다른 파일로 취급!

```
패키지와 모듈이란?
- 패키지
    - 서로 관련된 클래스 파일들을 묶어 놓은 디렉토리
    - 한 개 이상의 패키지로 작성
    - 패키지는 jar 파일로 압축 가능

- 모듈
    - 여러 패키지와 이미지 등의 자원을 모아 놓은 컨테이너
    - 하나의 모듈을 하나의 .jmod 파일에 저장

- 모듈화의 목적
    - 응용프로그램이 실행할 때 꼭 필요한 모듈들로만 실행 환경 구축 : 메모리 자원이 열악한 작은 소형 기기에 꼭 필요한 모듈로 구성된 작은 크기의 시행 이미지를 만들기 위함

    - 복잡한 개념
    - 큰 자바 응용프로그램에는 개발, 유지 보수 등에 적합

- 패키지 사용하기, import
    - 다른 패키지에 작성된 클래스 사용
        - import 이용 x
            => 소스에 클래스 이름의 완전 경로명 사용
        - 필요한 클래스만 import
            => 소스 시작 부분에 클래스의 경로명 import
            => import 패키지.클래스
            => 소스에는 클래스 명만 명시하면 됨
        - 패키지 전체를 import
            => 소스 시작 부분에 패키지의 경로명.* import
            => import 패키지.*
            => import java.util.*;

- 디폴트 패키지 
    - package 선언문이 없는 자바 소스 파일의 경우
        - 컴파일러는 클래스나 인터페이스를 디폴트 패키지에 소속시킴

```


## 4월 17일(7주차)

### this 레퍼런스 
```java
- 객체 자신에 대한 레퍼런스
    - 컴파일러에 의해 자동 관리, 개발자는 only 사용
    - this.멤버 형태로 멤버 접근 시 사용

ex) public class Circle {
    int radius;
    public Circle(int radius) {
        this.radius = radius; 
    }
    void set(int radius) {
        this.radius = radius; 
    }
    public static void main(String[] args) {
        Circle ob1 = new Circle(1);
        Circle ob2 = new Circle(2);
        Circle ob3 = new Circle(3);

        ob1.set(4);
        ob1.set(5);
        ob1.set(6);
    }
}
```
### this()로 다른 생성자 호출
- 같은 클래스의 다른 생성자 호출
- 생성자 내에서만 사용 가능
- 생성자 코드의 제일 처음 있어야 함

### 객체 배열
```java
- 객체에대한 레퍼런스 배열
- 객체 배열 만들기 3단계
    1. 배열 레퍼런스 변수 선언
    2. 레퍼런스 배열 생성
    3. 배열의 각 원소 객체 생성
    
    Circle [] c; // 1. 레퍼런스 변수 선언
    c = new Circle[5]; // 2. 레퍼런스 배열 생성

    for(int i = 0; i < c.length; i++)
        c[i] = new Circle(i); // 3. 각 원소 객체 생성

    for(int i = 0; i < c.length; i++) 
        System.out.println((int) (c[i].getArea()) + " ");   // 배열의 원소 객체 사용
```
---

### 메소드
```java
- 자바의 모든 메소드는 반드시 클래스 안에 존재!! (캡슐화)
- 메소드 형식
    public int getSum(int i, int j) {   // 접근 지정자, 리턴 타입, 메소드 이름, 메소드 인자들
        int sum;
        sum = i + j;    // 메소드 코드
        return sum;
    }
- 접근 지정자
    - public, private, protected, 디폴트(접근 지정자 생략)
```
#### 인자 전달
- 기본 타입의 값이 전달되는 경우
    - 매개 변수가 byte, int, double 등 기본 타입 선언 시
        - 값이 매개 변수에 복사되어 전달. = 실인자 값 변경 x
- 객제가 전달되는 경우
    - 객체의 레퍼런스만 전달
        - 매개 변수가 실인자 객체 공유
- 배열이 전달되는 경우
    - 배열 레퍼런스만 매개 변수에 전달
        - 베열 통째로 전달 x
    - 객체가 전달되는 경우와 동일
    ```java
    // 인자로 배열이 전달되는 예
    public class ArrayParameter {
        static void replaceSpace(char a[]) {
            for(int i = 0; i < a.length; i++)
                if(a[i] == ' ')
                    a[i] = ',';
        }
        static void replaceSpace(char a[]) {
            for(int i = 0; i < a.length; i++)
            System.out.println(a[i]);
        System.out.println();
        }
        public static void main(String[] args) {
            char c[] = 
            {'T', 'h', 'i', 's','','i','s','','a','','p','e','n','c','i','l','.'};
            printCharArray(c);
            replaceSpace(c);
            printCharArray(c);
        }
    }
    => This is a pencil.
       This,is,a,pencil.
    ```
---
### 메소드 오버로딩
- 오버로딩
    - 한 클래스 내에서 두 개 이상의 이름이 같은 메소드 작성
        - 메소드 이름 동일
        - 매개 변수의 개수가 서로 다르거나, 타입이 달라야 함
        - 리턴 타입은 오버로딩과 관련 x
- 객체 치환 시 주의할 점
    - 객체 치환은 객체 복사 x, 레퍼런스 복사 (≒ 포인터 / 주소 복사)
- 객체 소멸
    - new로 할당받은 객체와 배열 메모지를 JVM으로 되돌려 주는 행위
    - 자바는 객체 소멸 연산자 x
    - 객체 소멸은 JVM의 고유 역할
---
### 가비지
- 가비지
    - 가리키는 레퍼런스가 하나도 없는 객체
        - 더 이상 접근할 수 없어 사용할 수 없게 된 메모리
- 가비지 컬렉션
    - JVM의 가비지 컬렉터가 자동으로 가비지 수집, 반환

### 가비지 컬렉션 
- JVM의 가비지 자동 회수
    - 가용 메모리 공간이 일정 이할 부족해질 떄
    - 가비지를 수거 -> 가용 메모리 공간으로 확보
- 가비지 컬렉터에 의해 자동 수행
- 강제 가비지 컬렉션 강제 수행
    - System 또는 Runtime 객체의 gc() 메소드 호출
    ```java
    System.gc() // 가비지 컬렉션 잗동 요청
    ```
---

### 자바의 패키치
- 패키지
    - 상호 관련있는 클래스 파일(컴파일된 .class)을 저장하여 관리하는 디렉터리
    - 하나 이상의 패키지로 구성
---

### 접근 지정자
- public, private, protected, 디폴트(생략)
- 접근 지정자의 목적
    - 클래스나 일부 멤버를 공개하여 다른 클래스에서 접근하도록 허용
    - 캡슐화 정책은 멤버를 보호
        - 접근 지정은 캡슐화에 묶인 보호를 일부 해체할 목적
- 공개 범위
    - private < 디폴트 < protected < public
- 멤버 접근 지정
    - public    : 모든 클래스에게 접근 허용 
    - private   : 동일 클래스 내에서만 접근 허용 (상속받은 서브 클래스에서 접근 불가)
    - protected : 같은 패키지 내의 다른 모든 클래스에게 접근 허용 
    - 디폴트    : 같은 패키지 내의 다른 클래스에게 접근 허용
---

### static 멤버
```java
//static 멤버 선언

class StaticSample {
    int n;         // non-static
    void g() {...} // non-static 메소드

    static int m;         // static 필드
    static void f() {...} // static 메소드
}

- static 멤버는 클래스당 하나만 생성
- 객체들에 의해 굥유됨
```

- 클래스 이름으로 접근 가능
- 객체의 멤버로 접근 가능
- non-static 멤버는 클래스 이름으로 접근 불가능
<br><br>
- static 활용
    - 전역 변수와 전역 함수를 만들 때 활용
    - 공유 멤버를 만들고자 할 때

```java
ex) class Calc {
    public staitc int abs(int a) { return a>0?a:-a;}
    public staitc int max(int a, int b) { return (a>b)?a:b;}
    public staitc int min(int a, int b) { return (a>b)?b:a;}
    }
    public class CalcEx {
        public static void main(String[] args) {
            System.out.println(calc.abs(-5));
            System.out.println(calc.max(10, 8));
            System.out.println(calc.min(-3, -8));
        }
    }
    =>  5
        10
        -8
```
## 4월 10일(6주차)

### 예외 처리(try-catch-finally)
```java
발생한 예외에 대해 개발자가 작성한 프로그램 내에서 대응하는 것

try {
    예외 발생 가능성 있는 실행문
}
catch(처리할 예외 타입 선언) { // ex) ArithmeticException e
    예외 처리문
}
finally {
    예외 발생 여부와 상관없이 무조건 실행되는 문장 // 생략 가능
}
```

### 객체
    자신만의 고유한 특성(state)과 행동(behavior)을 가지며 다른 객체들에게 행동을 요구하거나 정보를 주고받는 등 상호 작용하며 살아감.
    - ex) TV, 의자, 책, 집, 카메라, ...

### 자바의 객체 지향 특성 : 캡슐화
    * 캡슐화 
    - 객체를 캡슐로 싸서 내부를 볼 수 없게 하는 것
    - 객체의 가장 본질적인 특징
    - 외부의 접근으로부터 객체를 보호함

    * 자바의 캡슐화
    - 클래스(class): 객체 모양을 선언한 틀(캡슐화하는 틀)
    - 객체: 생성된 실체(instance): 클래스 내에 메소드와 필드 구현

### 자바의 객체 지향 특성 : 상속
    * 상속
    - 상위 객체의 속성을 하위 객체에 물려 줌.
    - 하위 객체가 상위 객체의 속동을 모두 가지는 관계

    * 현실세계의 상속 사례
    - 나무는 식물의 속성과 생물의 속성을 모두 가짐
    - 사람은 생물의 속성은 가지지만 식물의 속성은 가지고 있지 않음

### 자바의 상속
```java
* 자바의 상속
- 상위 클래스의 멤버를 하위 클래스가 물려받음
- 상위 클래스: 슈퍼 클래스
- 하위 클래스: 서브 클래스, 슈퍼 클래스 코드 재사용, 새로운 특성 추가 O

ex) class Animal {
        String name;
        int age;
        void eat() {...}
        void speak() {...}
        void love() {...}
    }
            ↑ 상속
    class Human extends Animal {
        String hobby;
        String job;
        void work() {...}
        void cry() {...}
        void laugh() {...}
    }
```

### 자바의 객체 지향 특성: 다형성
    * 다형성
    - 같은 이름의 메소드가 클래스 혹은 객체에 따라 다르게 구현되는 것
    * 다형성 사례
    - 메소드 오버로딩: 한 클래스 내에서 같은 이름이지만 다르게 작동하는 여러 메소드
    - 메소드 오버라이딩: 슈퍼 클래스의 메소드를 동일한 이름으로 서브 클래스마다 다르게 구현

### 절차 지향 프로그래밍 & 객체 지향 프로그래밍
    * 절차 지향 프로그래밍
    - 작업 순서를 표현하는 컴퓨터 명령 집합
    - 함수들의 집합으로 프로그램 작성

    * 객체 지향 프로그래밍
    - 컴퓨터가 수행하는 작업을 객체들 간의 상호 작용으로 표현
    - 클래스 혹은 객체들의 집합으로 프로그램 작성

### 클래스 & 객체
    * 클래스
    - 객체의 속성과(state)과 행위(behavior) 선언. 객체의 설계도 or 틀

    * 객체
    - 클래스의 틀로 찍어난 실체
    - 프로그램 실행 중에 생성되는 실체
    - 메모리 공간을 갖는 구체적인 실체
    - 인스턴스(instance)라고도 함

### 자바 클래스 구성
```java
* 자바 클래스
- class 키워드로 선언
- 멤버: 클래스 구성 요소. 필드(멤버 변수) & 메소드(멤버 함수)
- 클래스에 대한 public 접근 지정: 다른 모든 클래스에서 클래스 사용 허락
- 멤버에 대한 public 접근 지정: 다른 모든 클래스에게 멤버 접근 허용

ex) public class Circle {
        int radius;     // 필드(멤버 변수)
        String name;

        public double getArea() {   // 메소드(멤버 함수)
            return 3.14*radius*radius;
        }
    }
``` 

### 객체 생성과 활용
```java
1. 레퍼런스 변수 선언
Circle pizza; // 레퍼런스 변수 pizza 선언
```

```java
2. new 연산자로 객체 생성
pizza = new Circle(); // Circle 객체 생성
```

```java
3. 선언과 동시에 객체 생성
Circle pizza = new Circle() // 레퍼런스 변수 pizza의 선언과 동시에 객체 생성
```

```java
4. 객체 멤버 접근
- 객체레퍼런스.멤버

ex) pizza.radius = 10; // pizza 객체의 radius 값을 10으로 설정
    pizza.name = "자바피자" // pizza 객체의 name에 "자바피자" 대입
    double area = pizza.getArea(); // pizza 객체의 getArea() 메소드 호출
```

### 생성자
    - 객체가 생성될 때 초기화 목적으로 실행되는 메소드
    - 객체가 생성되는 순간에 자동 호출

### 생성자의 특징
```java
생성자 이름은 클래스 이름과 동일
생성자는 여러 개 작성 가능(생성자 중복)

ex) public class Circle {
        public Circle() {...} // 매개 변수 없는 생성자
        public Circle(int r, String n) {...} // 2개의 매개 변수를 가진생성자    
    }
```

```java
생성자는 객체 생성 시 한번만 호출
자바에서 객체 생성은 반드시 new 연산자로 함
생성자의 목적은 객체 생성 시 초기화

ex) Circle pizza = new Circle(10, "자바피자");  // 생성자 Circle(int r, String n) 호출
    Circle donut = new Circle();                // 생성자 Circle() 호출

- 생성자는 리턴 타입 지정 불가

ex)
public void Circle() {...} // error. void를 리턴 타입으로 사용할 수 없음
```
--- 

## 4월 3일(5주차)

### for 문
```java
for(초기문; 조건식; 반복 후 작업) {
    ..작업문..
}
    
ex) 
for(int i = 0; i < 10; i++) {   // 0에서 9까지 출력
    System.out.print(i);
}

for <무한 반복>
for(초기문; true; 반복 후 작업) {
    ...........
}
    
for <무한 반복2>
for(초기문; ; 반복 후 작업) {
    ...........
}
- 반복 횟수를 카운팅 함
- 반복 횟수가 "정해져 있을 때" 많이 사용함
```

### while 문
```java
while(조건식) {
    .. 작업문 ..
}

ex)
int i = 0;          // for문과 달리 초기문을 while문 밖에 적어야함
while(i < 10) {     // 0에서 9까지 출력
    System.out.print(i);
    i++;
}

- 반복 횟수가 "정해져 있지 않을 때" 많이 사용함
- 조건식에 특정 조건을 집어넣고 그 조건을 만족하면 while 문을 벗어나게 할 수도 있음

    ex) while((n = scanner.nextInt()) != 0) {   // 0이 입력되면 while 문 벗어남
        ............
    }
```

### do-while 문
```java
do {
    .. 작업문 ..
} while(조건식)

ex) int i = 0;
    do { // 0에서 9까지 출력
        System.out.print(i);
        i++
    } while(i < 10);

=> 기본적으로 while 문과 동일하지만 처음에 조건식을 따지지 않으므로 작업문이 "적어도" 한번은 실행되는 특징이 있음
```

### 중첩 반복
```java
- 반복문 안에 다른 반복문을 만들 수 있음.
- for 문 안에 for 문이나 while 문을 둘 수도 있고, while 문 안에 for 문, while 문, do-while 문을 둘 수 있음

ex) for(int i = 0; i < 100; i++) {
        for(int j = 0; j < 1000; j++) {
            ...
            ...
        }
        ...
    }
```

### continue / break
- 반복문과 함께 사용되면서 반복의 흐름을 바꾸거나 반복에서 벗어나게 하는 중요한 기능을 함

### continue
```java
- 반복문을 빠져나가지 않으면서 즉시 다음 반복으로 넘어가고자할 때 사용함

1.
for(초기문; 조건식; 반복 후 작업) {
    ......
    continue;   // 반복 후 작업으로 분기함
    ......
}

2.
while(조건식) {
    ......
    continue;   // 조건식을 검사하는 과정으로 분기함
    ......
}

3.
do{
    ......
    continue;   // while문과 같음
    ......
} while(조건식)
```

### break
```java
- 하나의 반복문을 즉시 벗어날 때 사용함

1. 하나의 반복문을 벗어나는 경우
    for(초기문; 조건식; 반복 후 작업) {
        ......
        break;  // for 문을 벗어남.
        ......
    }
    ...... // 즉, 여기에서 시작

2. 중첩 반복에서 안쪽 반복문만 벗어나는 경우
    for(초기문; 조건식; 반복 후 작업) {
        while(조건식) {
            ......
            break; // while 문을 벗어나고 for 문에서 실행 유지
            ......
        }
        ...... // 즉, 여기에서 시작
    }
    ......
```

### 배열
- 인덱스(index)와 그에 대응하는 데이터들로 이루어진 연속적인 자료 구조
- 같은 종류의 데이터들이 순차적으로 저장됨

```java
1. 선언
- 레퍼런스 변수를 선언하는 것으로 배열 공간이 생성되지 않음
- 레퍼런스라고 불리는 배열의 주소 값을 가지는 상태일 뿐임
- c언어의 포인터라고 생각하면 이해하기 쉬움

int intArray[];     // 선언
선언 시 [] 안에 배열 크기를 지정하면 안됨
int intArray[5];    // 오류
```

```java
2. 생성
- 배열 공간을 할당받는 과정
- new 연산자를 이용하여 배열을 생성하며 [] 안에 생성할 원소 개수 지정
intArray = new int[5]; // 5개의 정수 배열 할당
```

```java
3. 선언 및 생성
int intArray[] = new int[5] // 배열 선언과 동시에 배열 생성
```

```java
4. 초기화
- 선언문에서 { } 사이에 원소를 나열하여 초기화된 배열 만들 수 있음
int intArray[] = {4, 3, 2, 1, 0}; // 크기는 자동으로 5가 됨
- 배열의 크기는 { } 사이에 나열된 값의 개수로 정해짐
```   

```java
5. 인덱스 / 원소 접근
- 인덱스는 0 이상의 양의 정수만 가능함
- 마지막 원소의 인덱스는 (배열 크기 - 1)

int intArray = new int[5] // 인덱스는 0~4까지 가능
intArray[0] = 5; // 원소 0에 5 저장
intArray[3] = 6; // 원소 3에 6 저장
int n = intArray[3]; // 원소 3의 값인 6을 n에 저장

* 오류
int n = intArray[-2]; // 인덱스는 음수 사용 불가
int m = intArray[5]; // intArray의 마지막 인덱스는 5이므로 범위 초과

* 오류2
int intArray[]; // 레퍼런스만 선언
intArray[1] = 8; // 배열이 생성되어 있지 않아 불가능
```

```java
6. 치환 / 배열 공유
자바는 배열 공간과 레퍼런스 변수가 분리되어 있기에 생성된 배열의 공유가 쉽게 이루어짐
int intArray[] = new int[5]; // 선언과 생성
int myArray[] = intArray; // 레퍼런스 치환, 쉽게 말해 myArray도 intArray와 동일한 배열의 주소값을 가짐
```

### 배열의 크기, length 필드
```java
자바는 배열을 객체로 다룸.
배열이 생성되면 배열 공간과 배열의 크기 값을 가진 length 필드가 배열 객체 내에 생성됨
length 필드를 사용하면 배열의 크기를 쉽게 알아낼 수 있음

int intArray[] = new int[5];
int size = intArray.length; // size = 5

for(int i = 0; i < intArray.length; i++) { // intArray 배열 크기만큼 루프
    System.out.print(intArray[i]);
}
```

### for-each 문
```java
배열이나 나열의 원소를 순차 접근하기에 유용

for(변수 : 배열레퍼런스) {
    .. 반복작업문 ..
}

ex) int n[] = {1, 2, 3, 4, 5};
    int sum = 0;
    for(int k : n) { // n.length 만큼 반복
        // 반복될 때마다 k는 n[0], ... n[4]로 설정
        sum += k;
    }
```
### 2차원 배열
```java
1. 선언
int intArray[][]; || int[][] intArray;
```
```java
2. 생성
intArray = new int[2][5]; // 2행 5열(2x5)의 2차원 배열 생성
* 첫번째 []는 행의 개수이고 두번째 []는 열의 개수임
```

```java
3. 선언 및 생성
int intArray[][] = new int[2][5];
```

```java
4. 초기화
배열을 선언할 때 원소를 초기화할 수 있음.
int intArray[][] = { {0, 1, 2}, {3, 4, 5}, {6, 7, 8} } // 3x3 배열 생성
```
```java
5. 구조
int i[][] = new int[2][5];
int size1 = i.length; // 2차원 배열의 행의 개수 = 2
int size2 = i[0].length; // 0번째 행의 열의 개수 = 5
int size3 = i[1].length; // 1번째 행의 열의 개수 = 5
```
### 메소드의 배열 리턴
    배열의 레퍼런스(주소)만 리턴됨
    리턴하는 배열 타입과 리턴 받는 배열 타입이 일치해야 함
    리턴 타입에 배열의 크기는 지정하지 않음

```java
ex) int[] intArray;

    int[] makeArray() {
        int temp[] = new int[4];
        return temp;
    }

    intArray = makeArray(); // temp 값(주소) 치환

    for(int i = 0; i < intArray.length; i++) { // 마음대로 사용 가능
        intArray[i] = i;
    }
```

## System.in vs. Scanner
### 1. System.in
    키보드와 연결된 자바의 표준 입력 스트림
    입력되는 키를 바이트로 리턴하는 저수준 스트림
    System.in을 직접 사용하면 바이트를 문자나 숫자로 변환하는 많은 어려움이 있음

### 2. Scanner 클래스
    읽은 바이트를 문자, 정수, 실수, 불린, 문자열 등 다양한 타입으로 변환하여 리턴함
```java
java.util.Scanner
객체를 생성해서 사용함.
키보드에 연결된 System.in에게 키를 읽게 하고, 원하는 타입으로 변환하여 리턴함
입력되는 키 값을 공백으로 구분되는 토큰 단위로 읽음.
공백 문자 : '\t', '\r', '\n', ' ', '\f' ...
```
---




## 3월 27일(4주차)

### 가비지 컬렉션
- 자바 언어는 메모리 할당 기능 O / 메모리 반환 기능 X
- 사용하지 않는 메모리는 JVM에 의해 자동 반환됨

### 실행 속도 계선을 위한 JIT 컴파일러 사용
- 자바는 바이트 코드를 인터프리터 방식으로 실행함
- 기계어가 실행되는 것보다는 느림
- JIT 컴파일 기법으로 실행 속도가 개선됨
---

## 소스 코드, 바이트 코드, 기계어

### 1. 소스코드(Source code)
- 우리가 작성하는 Java 코드 (.Java 파일)
- 사람이 읽을 수 있는 고급 언어

### 2. 바이트코드(Bytecode, .class 파일)
- Java 컴파일러(javac)가 소스코드를 변환한 중간 코드
- CPU가 직접 실행 불가능 => JVM이 실행해야 함
- 기계어와 다르게 플랫폼에 독립적임.
- 바이트코드는 JVM이 해석(인터프리터)하거나, JIT 컴파일러가 기계어로 변환하여 실행됨

### 3. 기계어(Machine Code)
- CPU가 직접 실행할 수 있는 0과 1의 이진 코드
- 운영체제(OS)와 CPU 아키텍처(Intel, ARM 등)에 따라 다르게 실행됨
- 16진수 형태의 기계어

### 4. 바이트코드와 기계어의 차이점
- 바이트코드는 JVM이 실행하는 중간 코드 ==> 운영체제와 CPU에 관계없이 사용 O
- 기계어는 CPU가 직접 실행하는 코드 ==> 특정 하드웨어에 종속됨

---
## System.out.print의 종류

### 1. System.out.print( )
- 기본 출력문
- 줄 바꿈을 하지 않고 한 줄로 출력함
- 줄 바꿈을 하려면 개행 문자 \n(new line)를 넣어야 함

### 2. System.out.println( )
- 출력 후 자동으로 줄 바꿈(개행)을 실행함.
- 개행 문자 없이 자동으로 줄 바꿈이 되기 때문에 자주 사용함
- print + line

### 3. System.out.printf( )
- 형식을 지정(formatting)하여 문자열을 출력할 때 사용함
- 값을 특정한 형식(소수점 자리 수, 정렬 등)으로 출력할 때 유용함

---