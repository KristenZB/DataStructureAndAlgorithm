package com.example.util;

import com.opencsv.bean.*;

import java.io.FileReader;
import java.io.Reader;
import java.util.*;

public class CSVReader {

    String path;
    
    public CSVReader(String path) {
        this.path = path;
    }

    public <T> List<T> getTestData(String csvName, Class<T> type) {
        List<T> result = null;
        try {
            Reader in = new FileReader(path + "/" + csvName + ".csv");
            MappingStrategy<T> strategy = new HeaderColumnNameMappingStrategyBuilder<T>().build();
            strategy.setType(type);
            result = new CsvToBeanBuilder<T>(in).withMappingStrategy(strategy).build().parse();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
