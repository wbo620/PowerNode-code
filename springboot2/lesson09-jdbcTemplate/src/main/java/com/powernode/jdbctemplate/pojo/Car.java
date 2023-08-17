package com.powernode.jdbctemplate.pojo;

import jakarta.persistence.*;
import lombok.*;

/**
 * User: hallen
 * Date: 2023/8/17
 * Time: 16:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Car {

    private Integer id;

    private String carNum;

    private String brand;

    private Double guidePrice;

    private String produceTime;

    private String carType;
}
