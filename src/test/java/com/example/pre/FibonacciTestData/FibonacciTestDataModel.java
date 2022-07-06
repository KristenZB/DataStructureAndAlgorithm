package com.example.pre.FibonacciTestData;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class FibonacciTestDataModel {

    @CsvBindByName
    Integer num;

    @CsvBindByName
    Long expectedResult;

    @CsvBindByName
    String remarks;
}
