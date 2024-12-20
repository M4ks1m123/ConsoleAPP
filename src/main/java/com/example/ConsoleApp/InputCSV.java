package com.example.ConsoleApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputCSV {

    public static void readFromCSV(TransactionRepository transactionRepository, String path) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                if(values[0].equals("customer_id"))
                    continue;
                Transaction first = new Transaction(Integer.valueOf(values[0]),
                        values[1],
                        Integer.valueOf(values[2]),
                        Integer.valueOf(values[3]),
                        Double.valueOf(values[4]),
                        Integer.valueOf(values[5]));
                transactionRepository.save(first);
            }
        }
    }
}
