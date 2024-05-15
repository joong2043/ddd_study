package com.example.ddd_study_1.domain;

import java.util.List;

public class Order {
    private List<OrderLine> orderLines;
    private Money totalAmounts;
    private OrderState state;
    private ShippingInfo shippingInfo;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    // OrderLine이 유효한지 테스트
    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no orderLine");
        }
    }

    private void calculateTotalAmounts() {
        int sum = orderLines.stream()
            .mapToInt(e -> e.getAmounts())
            .sum();
        this.totalAmounts = new Money(sum);
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("no shippingInfo");
        }

        this.shippingInfo = shippingInfo;
    }

    // 배송지 변경하기
    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);
    }

    private void verifyNotYetShipped() {
        if (state != OrderState.PREPARING && state!= OrderState.PAYMENT_WAITING) {
            throw new IllegalArgumentException("already shipped");
        }

    }

    // 출고 상태로 변경하기
    public void changedShipped() {

    }

    // 주문 취소하기
    public void cancel() {

    }

    // 결제완료하기
    public void completePayment() {

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