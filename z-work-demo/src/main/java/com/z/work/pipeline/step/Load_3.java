package com.z.work.pipeline.step;

import com.z.work.pipeline.ETLContext;
import com.z.work.pipeline.base.Step;

/**
 * @author zhaoxu
 * @date 1/6/2023 4:59 PM
 * @since
 */
public class Load_3 implements Step<ETLContext> {

    @Override
    public ETLContext run(ETLContext ctx) {
        System.out.println(ctx);
        return ctx;
    }
}
