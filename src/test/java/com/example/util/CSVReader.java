package com.example.util;

import com.opencsv.bean.*;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

import java.io.FileReader;
import java.io.Reader;
import java.util.*;

public class CSVReader {

    String path;
    
    public CSVReader(Class clazz) {

        // 删除 file: 字符串，只保留 /Users/xxx
        String packageName = Objects.requireNonNull(clazz.getResource("")).toString().substring(5);
        String folderName = clazz.getSimpleName() + "Data";
        this.path = packageName + folderName;
    }

    public <T> List<T> getTestData(String csvName, Class<T> type) {
        List<T> result = null;
        try {
            Reader in = new FileReader(path + "/" + csvName + ".csv");
            MappingStrategy<T> strategy = new HeaderColumnNameMappingStrategyBuilder<T>().build();
            strategy.setType(type);
            result = new CsvToBeanBuilder<T>(in).withFieldAsNull(CSVReaderNullFieldIndicator.BOTH).withMappingStrategy(strategy).build().parse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
