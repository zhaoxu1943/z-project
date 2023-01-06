package com.z.work.pipeline.step;

import com.z.common.entity.Student;
import com.z.work.pipeline.ETLContext;
import com.z.work.pipeline.base.Step;

/**
 * @author zhaoxu
 * @date 1/6/2023 4:52 PM
 * @since
 */
public class Trans_2 implements Step<ETLContext> {


    @Override
    public ETLContext run(ETLContext ctx) {
        Student s = (Student) ctx.getData();
        s.setId("1-process-trans");
        ctx.setData(s);
        return ctx;
    }
}
