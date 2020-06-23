package com.aimerrhythms.springcloud.feignapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aimerrhythms
 * @data 2020/6/6 21:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Integer id;
    private String name;

}
