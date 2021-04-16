package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: A사용자가 10000원 주문
        statefulService1.order("userA", 10000);
        // ThreadB: B사용자가 20000원 주문
        statefulService2.order("userB", 20000);

        // ThreadA: A사용자 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);  // 20000 출력

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000); // 이렇게 되면 망,,

        // ※ 공유필드 주의 ※ 스프링 빈은 항상 무상태(stateless)로 설계하자.

    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
