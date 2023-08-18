package com.powernode.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Car: hallen
 * Date: 2023/8/17
 * Time: 20:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    private Integer id;

    private String carNum;

    private String brand;

    private Double guidePrice;

    private String produceTime;

    private String carType;
}
