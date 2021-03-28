package com.dawndream.MailTwoStep.Config;

public class GetTime {
    public static void main(String arge[]){

        long data = System.currentTimeMillis();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(data);
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() - data);
    }
}