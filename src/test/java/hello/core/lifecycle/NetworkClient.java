package hello.core.lifecycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//javax. 이면 자바에서 공식적으로 지원하는 것, 즉 스프링이 아니라 다른 컨테이너를 쓰더라도 적용이 된다.

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);

    }
//url은 외부에서 세터로 넣을 수 있게 만듬
    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출하는 메서드
    public void connect() {
        System.out.println("connnet: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

    //afterPropertiesSet() = 의존관계 주입이 끝나면
    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
