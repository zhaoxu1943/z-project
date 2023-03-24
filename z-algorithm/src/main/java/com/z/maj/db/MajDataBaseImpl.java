package com.z.maj.db;

import cn.hutool.json.JSONUtil;
import com.z.maj.core.MajContext;
import com.z.maj.exception.MajException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static com.z.maj.core.MajConfig.DB_FILE_PATH;

@Slf4j
public class MajDataBaseImpl implements MajDataBase{

    @Override
    public void save(MajContext majContext) {
        String majContextJsonStr = JSONUtil.toJsonStr(majContext);

        try (OutputStream outputStream = new FileOutputStream(DB_FILE_PATH)) {
            outputStream.write(majContextJsonStr.getBytes());
        } catch (IOException e) {
            throw new MajException("maj db save error");
        }
    }

    @Override
    public MajContext query(String id) {
        return null;
    }

    @Override
    public void update(MajContext majContext) {

    }

    @Override
    public void delete(String id) {

    }
}
