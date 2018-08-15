package com.atguigu.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @auther zzyy
 * @create 2018-08-10 15:36
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class Person extends BaseEntity
{
    private int id;
    private String name;
    private int age;
}
