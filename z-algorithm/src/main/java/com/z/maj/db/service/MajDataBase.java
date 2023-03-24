package com.z.maj.db.service;

import com.z.maj.core.MajContext;

import java.util.List;

public interface MajDataBase {

    //存储
    void saveAfterQuery(MajContext majContext);


    List<MajContext> queryAllFromFile();

}
