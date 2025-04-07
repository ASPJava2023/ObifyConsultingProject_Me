package com.asp.ObifyConsulting.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyDTO {
    private Double n1;
    @JsonProperty("num2")
    private Double n2;
    private Double n3;

    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }

    public Double getN3() {
        return n3;
    }

    public void setN3(Double n3) {
        this.n3 = n3;
    }

    public Double getN4() {
        return n4;
    }

    public void setN4(Double n4) {
        this.n4 = n4;
    }

    private Double n4;

    @Override
    public String toString() {
        return "MyDTO{" +
                "n1=" + n1 +
                ", n2=" + n2 +
                ", n3=" + n3 +
                ", n4=" + n4 +
                '}';
    }
}
