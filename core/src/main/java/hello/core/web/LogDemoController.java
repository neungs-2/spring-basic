package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody // view 없이 문자열 그대로 응답 보내기 위함
    public String logDemo(HttpServletRequest request) throws InterruptedException {
        // 이렇게 로그를 남기는 코드는 컨트롤러보다 공통 처리가 가능한 스프링 인터셉터나 서블릿 필터를 활용하는 것이 더 좋다.
        // 예제를 단순화하기 위해 컨트롤러에서 처리했다.
        String requestURL = request.getRequestURI().toString();
//        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        Thread.sleep(5000);
        logDemoService.logic("testId");
        return "OK";
    }
}
