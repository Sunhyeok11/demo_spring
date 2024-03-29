package hello.demo.discount;

import hello.demo.member.Grade;
import hello.demo.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercemt = 10;


    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return price * discountPercemt / 100;
        } else {
            return 0;
        }
    }
}
