package hello.core.web;


import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerprovider; //mylogger를 주입받는 게 아니라 찾을 수 있는(룩업) 애가 주입이 되는 거다
    private final MyLogger myLogger; //mylogger를 주입받는 게 아니라 찾을 수 있는(룩업) 애가 주입이 되는 거다

//    @Autowired
//    public LogDemoController(LogDemoService logDemoService, MyLogger myLogger) {
//        this.logDemoService = logDemoService;
//        this.myLogger = myLogger;
//    }

    @RequestMapping("log-demo")
    @ResponseBody //=뷰 화면없이 문자를 반환하고 싶다
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        //자바에서 제공하는 표준 서블릿 규약, request 정보-고객요청정보를 받ㅇㄹ 수 있음
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        Thread.sleep(1000);
        logDemoService.logic("testId");
        return "ok";



    }
}
