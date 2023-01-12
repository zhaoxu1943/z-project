package com.z.work.pipeline;

import com.z.work.pipeline.base.BaseContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author zhaoxu
 * @date 1/6/2023 4:42 PM
 * @since
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ETLContext implements BaseContext {


    private String id;

    private Object data;
    

}
