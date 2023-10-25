package hello.core.singleton;

public class StatefulService {
    private int price; // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제!

        // 상태 공유 문제는 공유되는 필드를 제거하고 주입받은 가격을 그대로 리턴해주면 해결.
    }

    public int getPrice() {
        return price;
    }
}
