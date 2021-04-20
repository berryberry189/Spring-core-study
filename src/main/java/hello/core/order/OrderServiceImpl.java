package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
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
        Lombok @RequiredArgsConstructor
        final 이 붙은 필드(필수값)을 가지고 해당 필드를 파라미터로 갖는 생성자를 자동으로 만들어준다.
     */


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
