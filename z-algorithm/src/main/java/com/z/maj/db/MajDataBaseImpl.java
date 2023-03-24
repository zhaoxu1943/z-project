package com.z.maj.db;

import cn.hutool.json.JSONUtil;
import com.z.maj.core.MajContext;
import com.z.maj.db.service.MajDataBase;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class MajDataBaseImpl implements MajDataBase {

    @Override
    public void save(MajContext majContext) {
        String majContextJsonStr = JSONUtil.toJsonStr(majContext);

        String path =Thread.currentThread().getContextClassLoader().getResource("maj.db").getPath();
        File file = new File(path);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(majContextJsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
