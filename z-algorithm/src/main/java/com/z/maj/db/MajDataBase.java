package com.z.maj.db;

import com.z.maj.core.MajContext;

public interface MajDataBase {

    //存储
    void save(MajContext majContext);

    //查询
    MajContext query(String id);

    //更新
    void update(MajContext majContext);

    //删除
    void delete(String id);
}
