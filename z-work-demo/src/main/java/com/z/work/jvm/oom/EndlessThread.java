package com.z.work.jvm.oom;

import cn.hutool.system.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class EndlessThread {


    //无限创建线程会导致OOM吗
    public static void main(String[] args) {

        List<UserInfo> ls = new ArrayList<>();
        while(true){
            UserInfo userInfo = new UserInfo();

            ls.add(userInfo);
        }

    }
}
