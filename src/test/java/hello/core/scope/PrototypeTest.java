package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        //AnnotationConfigApplicationContext에 (PrototypeBean.class) 으로 지정해주면, 클래스가 컴퍼넌트스캔의 대상 자체, 대상처럼 동작하기 때문에 컴포넌트스캔처럼 등록해버린다. 그래서 @컴포넌트스캔 없어도 된다.
        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);


        prototypeBean1.destroy(); //destroy가 필요하면  이렇게 직접 호출해줘야 한다.
        prototypeBean2.destroy(); //destroy가 필요하면 이렇게 직접 호출해줘야 한다.
        ac.close();

    }


    @Scope("prototype")
//    @Component
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }

    }

}
