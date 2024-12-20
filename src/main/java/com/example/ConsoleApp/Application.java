package com.example.ConsoleApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Application{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(TransactionRepository transactionRepository){
		return args -> {
			InputCSV inputCSV = new InputCSV();
			OutputCSV outputCSV = new OutputCSV();
			Scanner scanner = new Scanner(System.in);

			while (true) {
				try {
					System.out.println("\nEnter input file path");
					String filepath = scanner.next();
					inputCSV.readFromCSV(transactionRepository, filepath);
					break;
				}catch (FileNotFoundException e){
					System.out.println("Error, directory was not found. Please, try again");
				}
			}

			System.out.println("\nEnter CustomerID");
			Integer customerId = scanner.nextInt();

			// C:/Users/Caster/Desktop/test_csv.csv
			// C:/Users/Caster/Desktop/for_csv/mistake_path
			// C:/Users/Caster/Desktop/for_csv

			List<Object[]> queryResults1 = transactionRepository.selectQuery1(customerId);
			List<Object[]> queryResults2 = transactionRepository.selectQuery2(customerId);
			while (true) {
				try {
					System.out.println("\nEnter path for results");
					String filepath = scanner.next();
					outputCSV.saveToCSV1(queryResults1, filepath, customerId);
					outputCSV.saveToCSV2(queryResults2, filepath, customerId);
					System.out.println("Data saved to CSV files successfully!");
					break;
				} catch (IOException e) {
					System.out.println("Error, directory was not found. Please, try again");
				}
			}
		};
	}
}

