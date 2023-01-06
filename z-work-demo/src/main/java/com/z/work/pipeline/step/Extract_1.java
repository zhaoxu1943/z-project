package com.z.work.pipeline.step;

import com.z.common.entity.Student;
import com.z.work.pipeline.ETLContext;
import com.z.work.pipeline.base.BaseContext;
import com.z.work.pipeline.base.Step;

/**
 * @author zhaoxu
 * @date 1/6/2023 4:44 PM
 * @since
 */
public class Extract_1 implements Step<BaseContext> {

    @Override
    public BaseContext run(BaseContext ctx) {
        return new ETLContext().setId("1").setData(new Student().setId("1").setName("张老三"));
    }
}
