package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean, DisposableBean {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    @Override
    // 초기화 콜백
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet: " + url);
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    // 소멸전 콜백
    public void destroy() throws Exception {
        disconnect();
    }
}
