package com.z.work.pipeline;

import com.z.work.pipeline.base.Pipe;
import com.z.work.pipeline.base.Step;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxu
 * @date 1/10/2023 4:50 PM
 * @since
 */
@RequiredArgsConstructor
public class ScorePipeline implements Pipe {

    @Nonnull
    private ETLContext ctx;

    private List<Step> pipelineSteps = new ArrayList<>();

    public void addStep(Step step) {
        pipelineSteps.add(step);
    }

    public void execute() {
        for (Step step : pipelineSteps) {
            Object out = step.run(ctx);
        }
    }



}
