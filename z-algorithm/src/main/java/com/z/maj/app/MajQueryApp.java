package com.z.maj.app;

import com.z.maj.core.MajContext;
import com.z.maj.db.MajDataBaseImpl;
import com.z.maj.db.service.MajDataBase;

import java.util.List;

public class MajQueryApp {

    public static void main(String[] args) {
        MajDataBase db = new MajDataBaseImpl();
        List<MajContext> majContexts = db.queryAllFromFile();
        for (MajContext context:majContexts) {
            System.out.println(context);
        }
    }
}
