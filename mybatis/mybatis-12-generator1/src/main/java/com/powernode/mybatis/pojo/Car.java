package com.powernode.mybatis.pojo;

import java.math.BigDecimal;

public class Car {
    private Integer id;

    private String carNum;

    private String brand;

    private BigDecimal guidePrice;

    private String produceTime;

    private String carType;

    public Car() {
    }

    public Car(Integer id, String carNum, String brand, BigDecimal guidePrice, String produceTime, String carType) {
        this.id = id;
        this.carNum = carNum;
        this.brand = brand;
        this.guidePrice = guidePrice;
        this.produceTime = produceTime;
        this.carType = carType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum == null ? null : carNum.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public BigDecimal getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(BigDecimal guidePrice) {
        this.guidePrice = guidePrice;
    }

    public String getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime == null ? null : produceTime.trim();
    }

    public String getCarType() {
        return carType;
    }



    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    public String toString() {
        return "Car{id = " + id + ", carNum = " + carNum + ", brand = " + brand + ", guidePrice = " + guidePrice + ", produceTime = " + produceTime + ", carType = " + carType + "}";
    }
}