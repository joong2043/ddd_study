package com.example.ddd_study_1.domain;

public class Order {
    private OrderState state;
    private ShippingInfo shippingInfo;

    // 배송지 변경하기
    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        // 만약 state의 배송 변경이 가능하지 않다면 에러
        if (!isShippingChangeable()) {
            throw new IllegalArgumentException("cant change shipping in" + state);
        }

        this.shippingInfo = newShippingInfo;
    }

    private boolean isShippingChangeable() {
        return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING;
    }


}

public enum OrderState {
    PAYMENT_WAITING,
    PREPARING,
    SHIPPED, DELIVERING, DELIVERY_COMPLETED;

    public boolean isShippingChangeable() {
        return false;
    }
}