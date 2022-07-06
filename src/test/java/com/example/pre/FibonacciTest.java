package com.example.pre;

import com.example.base.TestBase;
import com.example.pre.FibonacciTestData.FibonacciTestDataModel;
import com.example.util.CSVReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

import static com.example.pre.Fibonacci.basicFibonacci;

public class FibonacciTest extends TestBase {

    CSVReader csvReader;

    @BeforeClass
    void init() {
        // 删除 file: 字符串，只保留 /Users/xxx
        String packageName = Objects.requireNonNull(this.getClass().getResource("")).toString().substring(5);
        String folderName = this.getClass().getSimpleName() + "Data";
        csvReader = new CSVReader(packageName + folderName);
    }

    @Test
    public void testBasicFibonacci() {
        List<FibonacciTestDataModel> dataList = csvReader.getTestData("basicFibonacci", FibonacciTestDataModel.class);
        for (FibonacciTestDataModel data : dataList) {
            Assert.assertEquals(data.getExpectedResult(), basicFibonacci(data.getNum()));
            System.out.println(data.getRemarks());
        }
    }

    @Test
    void testImprovedFibonacci() {
        List<FibonacciTestDataModel> dataList = csvReader.getTestData("improvedFibonacci", FibonacciTestDataModel.class);
        for (FibonacciTestDataModel data : dataList) {
            Assert.assertEquals(data.getExpectedResult(), basicFibonacci(data.getNum()));
            System.out.println(data.getRemarks());
        }
    }

}