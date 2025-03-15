package framework.utils;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public  class CsvReader {

    public static Object[][] readCsvData(String csvFile) {
        List<Object[]> data = new ArrayList<>();
        String line;
        boolean isFirstLine = true;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip the header
                    continue;
                }
                String[] values = line.split(","); // Assuming comma as delimiter
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.toArray(new Object[0][]);
    }

}
