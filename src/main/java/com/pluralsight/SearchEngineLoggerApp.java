package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLoggerApp {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter format;
        format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        boolean isRunning = true;
        String formatedDate = today.format(format);
        System.out.println("What is the text file you want to write to?");
        String doc=input.nextLine();
        try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(doc));
        String launch = " Launch";
        System.out.println(formatedDate + launch);
        writer.write(formatedDate + launch+"\n");
        while(isRunning) {
            System.out.println("Enter a search term (X to exit):");
            String searchTerm = input.nextLine();

            if(searchTerm.equalsIgnoreCase("X")) {
                isRunning = false;
                String exit=" exit";
                System.out.println(formatedDate+exit);
                writer.write(formatedDate+exit);
            } else{
                String search="search : ";
                System.out.println(formatedDate + " "+search + searchTerm);
                writer.write(formatedDate + " "+search + searchTerm+"\n");
            }
        }
        writer.close();

        } catch (IOException e) {
            System.out.println("File not found. Please try again.");
            throw new RuntimeException(e);
        }
    }

}
