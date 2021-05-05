# [인프런] 스프링 핵심 원리 - 기본
***


## 목차
- [SOLID](#SOLID)
- [스프링 컨테이너](https://www.notion.so/94ac4e7898e842d58bec9ca567c92d63)
- [설정 형식 지원 - 자바코드, XML](https://www.notion.so/XML-ef8e8cfbd6764a17a0157b14482f10e2)
- [BeanDefinition](https://www.notion.so/BeanDefinition-550bafc69e9b4ad792edeaa081451a8b)
- [싱글톤, @Configuration](https://www.notion.so/Configuration-dfc12e57ce5a4d15852fa0dbcd19040e)
- [@Component, @Autowired](https://www.notion.so/Component-Autowired-d37c307d592d4d78910008714a11a3f0)




## SOLID
*좋은 객체지향 설계의 5가지 법칙*

#### SRP 단일 책임 원칙
> “한 클래스는 하나의 책임만 가져야 한다.”
* 클라이언트 객체는 실실행만 하는 책임만 담당

#### DIP 의존관계 역전 원칙
> “프로그래머는 추상호에 의존해야지 구체화에 의존하면 안된다. 의존성 주입은 이 원칙을 따르는 방법 중 하나다.”  

*예제코드)*<br>
* AppConfig가 FixDiscount객체 인스턴스를 클라이언트 코드 대신 생성해서 클라이언트 코드에 의존관계를 주입함

#### OCP 개방 폐쇠 원칙
> “소프트웨어 요소는 확장에는 열려있으나 변경에는 닫혀 있어야 한다.”
> “소프트웨어 요소를 새롭게 확장해도 사용 영역의 변경은 닫혀있다.”  

*예제코드)*<br>
* AppConfig가 의존관계를 FixDiscountPolicy → RateDiscountPolicy로 변경하여 클라이언트에 주입하므로 클라이언트 코드는 변경하지 않아도 됨

### IoC, DI, 컨테이너

#### IoC 제어의 역전
*예제코드)*
* 기존에는 구현 객체가 프로그램의 제어 흐름을 스스로 조종했지만, 
  AppConfig 생성 후의 구현 객체는 자신의 로직을 실행하는 역할만 담당하며, 프로그램 제어의 흐름에 대한 권한은 AppConfig가 가지고 있다.  
  → 프로그램 제어 제어 흐름을 외부에서 관리하는 것을 **제어의 역전(IoC)** 이라고 한다.

#### DI 의존성 주입
*예제코드)*
* OrderServiceImpl 은 DiscountPolicy 인터페이스에 의존한다. 실제 어떤 구현 객체가 사용될지는 모른다.

