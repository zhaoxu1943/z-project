package com.z.play;

public class Maj_4 {

    public static int[] sldk19 = new int[]{18800,38200};

    public static int[] caochu = new int[]{42600,36300};

    public static int[] haoge = new int[] {12500,19700};

    public static int[] z = new int[] {26100,5800};

    public static int[] a_003 = new int[] {26100,5800};

    public static double money = 5.0d;

    public static int time = 2;

    public static int person_3 = 3;

    public static int person_4 = 4;

    public static int type_3 = 35000;

    public static int type_4 = 25000;

    public double sumAll  = type_4*time*person_4;

    public double moneyAll = money*person_4*time;

    public int getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length-1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        Maj_4 maj = new Maj_4();
        System.out.println("sldk19:"+maj.arrayToString(sldk19)+",总分:"+maj.getSum(sldk19)+",占比:"+maj.getSum(sldk19)/ maj.sumAll*100+"%,钱:"+maj.getSum(sldk19)/ maj.sumAll* maj.moneyAll+"元");
        System.out.println("caochu:"+maj.arrayToString(caochu)+",总分:"+maj.getSum(caochu)+",占比:"+maj.getSum(caochu)/ maj.sumAll*100+"%,钱:"+maj.getSum(caochu)/ maj.sumAll* maj.moneyAll+"元");
        System.out.println("haoge:"+maj.arrayToString(haoge)+",总分:"+maj.getSum(haoge)+",占比:"+maj.getSum(haoge)/ maj.sumAll*100+"%,钱:"+maj.getSum(haoge)/ maj.sumAll* maj.moneyAll+"元");
        System.out.println("z:"+maj.arrayToString(z)+",总分:"+maj.getSum(z)+",占比:"+maj.getSum(z)/ maj.sumAll*100+"%,钱:"+maj.getSum(z)/ maj.sumAll* maj.moneyAll+"元");



    }

}
