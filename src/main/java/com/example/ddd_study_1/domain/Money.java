package com.example.ddd_study_1.domain;

public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // 밸류 타입의 장점은 밸류 타입을 위한 기능을 추가할 수 있음
    public Money add(Money money) {
        return new Money(this.value + money.value);
    }

    public Money multiply(int multiplier) {
        return new Money(this.value * multiplier);
    }
}
