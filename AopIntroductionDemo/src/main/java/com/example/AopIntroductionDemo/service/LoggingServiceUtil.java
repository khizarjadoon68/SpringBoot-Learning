package com.example.AopIntroductionDemo.service;

public class  LoggingServiceUtil {

    public static void logStart(String className ,String methodName){
        System.out.println("Executing -> "+className+ " : "+methodName);
    }
    public static void logEnd(String className ,String methodName){
        System.out.println("finishing -> "+className+ " : "+methodName);
    }

}
