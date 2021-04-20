package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
    /**
     * 더 이상 FixDiscountPolicy 를 의존하지 않는다
     * OrderServiceImpl 입장에서 생성자를 통해 어떤 구현 객체가 들어올지(주입될지)는 알 수 없다
     * 생성자를 통해 어떤 구현 객체를 주입할지는 오직 외부(AppConfig)에서 결정한다
     * OrderServiceImpl는 실행에만 집중하면 된다
     */

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /**
     @Autowired 매칭
        1. 타입 매칭
        2. 타입 매칭의 결과가 2개 이상일 때 필드 명, 파라미터 명으로 빈 이름 매칭

     @Qualifier
        추가 구분자를 붙여주는 방법
        ex) RateDiscountPolicy -> @Qualifier("mainDiscountPolicy")
            FixDiscountPolicy  -> @Qualifier("fixDiscountPolicy")

     @Primary
         우선순위를 정하는 방법
         @Autowired 시에 여러 빈이 매칭되면 @Primary 가 우선권을 가진다.

      +) @Primary 는 기본값 처럼 동작하는 것이고, @Qualifier 는 매우 상세하게 동작하며,
         @Qualifier 가 더 우선순위가 높다
         
     */
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy  DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
