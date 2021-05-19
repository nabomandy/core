package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Bean memberService-> new MemoryMemberRepository()
// @Bean orderService -> new MemoryMemberRepository()MemoryMemberRepository

//call AppConfig.memberService
//call AppConfig.memberRepository
//call AppConfig.memberRepository
//call AppConfig.orderService
//call AppConfig.memberRepository

//call AppConfig.memberService
//call AppConfig.memberRepository
//

@Configuration
public class AppConfig {
    //전체를 설정하고 구성한다는 뜻

    @Bean
    //MemberService의 역할
    public MemberService memberService(){
        System.out.println("call AppConfig.memberSer\n" +
                "\n" +
                "    @Beanvice");
        return new MemberServiceImpl(memberRepository());
    }
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}