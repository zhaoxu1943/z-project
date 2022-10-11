package com.z.common.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author zhaoxu
 * @date 2022/6/14 13:29
 * @since
 */
@Data
@Accessors(chain = true)
public class Student {

    private String id;

    private String name;
}
