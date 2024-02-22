package hello.demo.order;

import hello.demo.discount.DiscountPolicy;
import hello.demo.member.Member;
import hello.demo.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements  OrderService{

    @Autowired private MemberRepository memberRepository;
    @Autowired private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
