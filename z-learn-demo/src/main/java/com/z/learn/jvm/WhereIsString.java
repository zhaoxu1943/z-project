package com.z.learn.jvm;


import cn.hutool.core.lang.UUID;
import org.assertj.core.util.Lists;

import java.util.List;

/**
 * String 常量池在哪?
 *
 * @author zhaoxu
 */
public class WhereIsString {

    /**
     * 调用 intern 方法时，
     * 如果池已包含与该方法确定equals(Object)的此对象相等的String字符串，
     * 则返回池中的字符串。
     * 否则，此String对象将添加到池中，并返回对此String对象的引用。
     *
     * @author zhaoxu
     */
    public static void main(String[] args) throws Exception {
        List<String> list = Lists.newArrayList();
        while (true) {
            list.add(UUID.fastUUID().toString().intern());
        }
    }

}
