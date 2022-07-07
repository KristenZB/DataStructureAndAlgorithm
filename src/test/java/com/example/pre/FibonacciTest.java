package com.example.pre;

import com.example.base.TestBase;
import com.example.pre.FibonacciTestData.FibonacciTestDataModel;
import com.example.util.CSVReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.example.pre.Fibonacci.basicFibonacci;

public class FibonacciTest extends TestBase {

    CSVReader csvReader;

    @BeforeClass
    void init() {

        csvReader = new CSVReader(this.getClass());
    }

    @Test
    public void testBasicFibonacci() {
        List<FibonacciTestDataModel> dataList = csvReader.getTestData("basicFibonacci", FibonacciTestDataModel.class);
        for (FibonacciTestDataModel data : dataList) {
            Assert.assertEquals(basicFibonacci(data.getNum()), data.getExpectedResult());
            System.out.println(data.getRemarks());
        }
    }

    @Test
    void testImprovedFibonacci() {
        List<FibonacciTestDataModel> dataList = csvReader.getTestData("improvedFibonacci", FibonacciTestDataModel.class);
        for (FibonacciTestDataModel data : dataList) {
            Assert.assertEquals(basicFibonacci(data.getNum()), data.getExpectedResult());
            System.out.println(data.getRemarks());
        }
    }

}