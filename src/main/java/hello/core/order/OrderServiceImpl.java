package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    //오더서비스는 두개가 필요하다
    private final MemberRepository memberRepository;
    //final이라는 뜻은 얘는 꼭 값이 있어야 한다는 거. 왠만하면 무조건 세팅을 해줘!
    //-> 멤버레퍼지토리에서 회원찾아야되니까
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy;

//    @RequiredArgsConstructor가 아래거를 만들어줌
    @Autowired//생성자가 하나일때는 오토와이어드 없어도 됨. 그렇게 많이 사용한다 요즘은
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    //        System.out.println("memberRepository = " + memberRepository);
//        System.out.println("discountPolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //회원 정보를 조회하고
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인정책에다가 회원을 그냥 넘긴거다.

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }



}
