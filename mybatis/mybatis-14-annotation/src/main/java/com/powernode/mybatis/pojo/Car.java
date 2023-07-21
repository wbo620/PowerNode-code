package com.powernode.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Car {
    private Integer id;

    private String carNum;

    private String brand;

    private Double guidePrice;

    private String produceTime;

    private String carType;

}