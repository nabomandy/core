package hello.core.common;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
//@Scope(value = "request") //value 뺴도 됨 넣은 이유는 값이 두개이상 들어가야 해서
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
//proxyMode = ScopedProxyMode.TARGET_CLASS는 가짜 프록시 클래스를 만들어서 주입해준다.
public class MyLogger { //로그를 출력하기 위한 클래스

    private String uuid;
    private String requestURL;//나중에 별도로 세팅하도록 세터로 중간에 들어오도록 함

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct//고객요청이 들어올 때 스프링에 달라고 할 때 호출해주고
    public void init() {
        uuid = UUID.randomUUID().toString(); //UUID에서 랜덤UUID를 투스트링으로 받는 거. 절대 안겹치는 UUID받는다.
        System.out.println("[" + uuid + "] + request scope bean create:" + this);
    }//this를 하면 얘 주소가 나오겠죠

    @PreDestroy
    public void close(){ //고객 요청이 서버에서 빠져나가면 소멸
        System.out.println("[" + uuid + "] + request scope bean close:" + this);

    }


}
