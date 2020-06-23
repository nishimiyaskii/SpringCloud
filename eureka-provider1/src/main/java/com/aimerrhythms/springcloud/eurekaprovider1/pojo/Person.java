package com.aimerrhythms.springcloud.eurekaprovider1.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aimerrhythms
 * @data 2020/6/5 21:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String id;
    private String name;
    private Integer age;

}
