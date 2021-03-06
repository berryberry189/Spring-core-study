package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 애플리케이션에 대한 환경 구성
 * 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다
 * 생성한 객체 인스턴스의 참조(래퍼런스)를 생성자를 통해서 주입(연결)해준다
 * 객체의 생성과 연결을 담당
 */

@Configuration // 설정 정보
public class AppConfig {


    // @Bean  memberService -> new MemoryMemberRepository()
    // @Bean  orderService  -> new MemoryMemberRepository()

    @Bean // 스프링 컨테이너너 등록 됨
    public MemberService memberService(){
        /**
         * MemberServiceImpl 은 MemoryMemberRepository 인  추상에만 의존하면 됨
         * 구체 클래스를 몰라도 된다
         * AppConfig -> MemoryMemberRepository  생성
         * AppConfig -> MemberServiceImpl 생성 + 주입
         */

        System.out.println("call AppConfig.memberService");

                                     // 생성자 주입
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
