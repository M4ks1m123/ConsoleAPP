package com.example.ConsoleApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputCSV {

    public void saveToCSV1(List<Object[]> listOfObjects, String filepath, Integer customerId) throws IOException{

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath +
                "/MaxTransaction_id"+customerId+".csv", false))) {
            bufferedWriter.write("customer_id" + "," + "max_amount" + "\n");
            for (Object[] transaction : listOfObjects) {
                   bufferedWriter.write(transaction[0] + "," + transaction[1] + "\n");
            }
        }
    }

    public void saveToCSV2(List<Object[]> listOfObjects, String filepath, Integer customerId) throws IOException{
        try(BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(filepath+
                "/MostCommonTransaction_id"+customerId+".csv", false))){
            bufferedWriter.write("customer_id" + "," + "amount" + ","+ "count" + "\n");
            for(Object[] transaction : listOfObjects) {
                bufferedWriter.write(transaction[0] + ","+ transaction [1] + ","+ transaction [2]+"\n");
            }
        }
    }
}

