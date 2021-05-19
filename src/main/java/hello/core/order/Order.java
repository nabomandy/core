package hello.core.order;

public class Order {
//주문에서 할인 다 끝나고 했을 때 만들어지는 객체
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountprice;

    public Order(Long memberId, String itemName, int itemPrice, int discountprice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountprice = discountprice;
    }

    //비즈니스 계산 로직 추가
    public int calculaterPrice(){
        return itemPrice - discountprice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(int discountprice) {
        this.discountprice = discountprice;
    }

    //객체를 출력하면 투스트링의 결과가 짝 출력된다.
    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountprice=" + discountprice +
                '}';
    }
}
