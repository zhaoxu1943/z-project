package com.z.maj.app;

import com.z.maj.core.MajCalculate;
import com.z.maj.core.MajContext;
import com.z.maj.db.MajDataBaseImpl;
import com.z.maj.db.service.MajDataBase;

public class MajCalApp {



    public static void main(String[] args) {

        MajCalculate cal = new MajCalculate();
        MajDataBase db = new MajDataBaseImpl();

        String origin = "友人場\n" +
                "1位 stephen1943        75500        2位 无敌衡神        32200        \n" +
                "3位 毒瘤小张        -2700        \n" +
                "友人場\n" +
                "1位 无敌衡神        42800        2位 毒瘤小张        32100        \n" +
                "3位 stephen1943        30100        \n" +
                "友人場\n" +
                "1位 毒瘤小张        47200        2位 stephen1943        40100        \n" +
                "3位 无敌衡神        17700\n" +
                "友人場\n" +
                "1位 无敌衡神        57600        2位 毒瘤小张        29400        \n" +
                "3位 stephen1943        18000        \n" +
                "友人場\n" +
                "1位 stephen1943        71000        2位 毒瘤小张        35000        \n" +
                "3位 无敌衡神        -1000        \n" +
                "友人場\n" +
                "1位 无敌衡神        49100        2位 stephen1943        34300        \n" +
                "3位 毒瘤小张        21600 \n" +
                "友人場\n" +
                "1位 stephen1943        75700        2位 毒瘤小张        14900        \n" +
                "3位 无敌衡神        14400        \n" +
                "友人場\n" +
                "1位 毒瘤小张        54000        2位 无敌衡神        35700        \n" +
                "3位 stephen1943        15300";


        MajContext majContext = cal.calculate(origin);
        //进行maj存储
       //db.saveAfterQuery(majContext);
    }


}
