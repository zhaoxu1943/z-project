package com.z.play;

public class Maj_3 {



    public static int[] caochu = new int[]{57000,45400};

    public static int[] z = new int[] {18500,70400};

    public static int[] a_003 = new int[] {29500,-10800};



    public static double money = 3.5d;

    public static int time = 2;

    public static int person_3 = 3;

    public static int type_3 = 35000;



    public double sumAll  = type_3*time*person_3;

    public double moneyAll = money*person_3*time;

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
        Maj_3 maj = new Maj_3();
        System.out.println("caochu:"+maj.arrayToString(caochu)+",总分:"+maj.getSum(caochu)+",占比:"+maj.getSum(caochu)/ maj.sumAll*100+"%,钱:"+maj.getSum(caochu)/ maj.sumAll* maj.moneyAll+"元");
        System.out.println("1943:"+maj.arrayToString(z)+",总分:"+maj.getSum(z)+",占比:"+maj.getSum(z)/ maj.sumAll*100+"%,钱:"+maj.getSum(z)/ maj.sumAll* maj.moneyAll+"元");
        System.out.println("003:"+maj.arrayToString(a_003)+",总分:"+maj.getSum(a_003)+",占比:"+maj.getSum(a_003)/ maj.sumAll*100+"%,钱:"+maj.getSum(a_003)/ maj.sumAll* maj.moneyAll+"元");


    }

}
