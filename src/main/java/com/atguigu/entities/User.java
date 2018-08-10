package com.atguigu.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @auther zzyy
 * @create 2018-08-10 14:53
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class User implements Serializable
{
    private Integer id;
    private String  userName;
    private Integer age;
}
