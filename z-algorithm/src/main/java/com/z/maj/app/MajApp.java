package com.z.maj.app;

import com.z.maj.core.MajCalculate;
import com.z.maj.core.MajContext;
import com.z.maj.db.service.MajDataBase;
import com.z.maj.db.MajDataBaseImpl;

public class MajApp {



    public static void main(String[] args) {

        MajCalculate cal = new MajCalculate();
        MajDataBase db = new MajDataBaseImpl();

        String origin = "友人塌\n" +
                "1位 sldk19\n" +
                "3位 FeiClusell\n" +
                "2位 毒瘤小张38200\n" +
                "4位 stephen1943\n" +
                "19700\n" +
                "36300\n" +
                "5800\n" +
                "友人塌\n" +
                "1位 毒瘤小张3位 sldk19\n" +
                "2位 stephen194342600\n" +
                "4位 FeiClusell18800\n" +
                "26100\n" +
                "12500";

        MajContext majContext = cal.calculate(origin);
        //进行maj存储
        db.save(majContext);

        System.out.println("1");

    }


}
