package hello.core.singleton;

public class StatefulService {

//    private int price; //가격이란 필드, 상태를 유지하는 필드 10000 -> 20000으로 바꿔치기 되는거

    public int order(String name, int price) {
        System.out.println("name = " + name+ "price = " + price);
//        this.price = price; //여기가 문제!
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
