package com.example.base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.LocalDateTime;

public class TestBase {

    long beginTime;
    long endTime;

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " - 执行开始：" + LocalDateTime.now());
        beginTime = System.currentTimeMillis();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        endTime = System.currentTimeMillis();
        System.out.println(result.getMethod().getMethodName()  + " - 执行结束：" + LocalDateTime.now());
        double delta = (endTime - beginTime) / 1000.0;
        System.out.println("耗时：" + delta + "秒");
        System.out.println("=========");
    }
}
