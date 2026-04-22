package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter format;
        format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        boolean isRunning = true;
        String formattedDate = today.format(format);
        System.out.println("What is the text file you want to write to?");
        String doc=input.nextLine();
        logSearchActivity(doc, formattedDate, isRunning, input);
    }
    private static void logSearchActivity(String doc, String formatedDate, boolean isRunning, Scanner input) {
        try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(doc));
        String launch = " Launch";
        System.out.println(formatedDate + launch);
        writer.write(formatedDate + launch+"\n");
            handleSearchInput(isRunning, input, writer, formatedDate);
            writer.close();

        } catch (IOException e) {
            System.out.println("File not found. Please try again.");
            throw new RuntimeException(e);
        }
    }

    private static void handleSearchInput(boolean isRunning, Scanner input, BufferedWriter writer, String formatedDate) throws IOException {
        while(isRunning) {
            System.out.println("Enter a search term (X to exit):");
            String searchTerm = input.nextLine();

            if(searchTerm.equalsIgnoreCase("X")) {
                String exit=" exit";
                isRunning = false;
                //System.out.println(formatedDate+exit); to check if I am receiving and writing the information/searches properly
                writer.write(formatedDate +exit);
            } else{
                String search="search : ";
                //System.out.println(formatedDate + " "+search + searchTerm);to check if I am receiving and writing the information/searches properly
                writer.write(formatedDate + " "+search + searchTerm+"\n");
            }
        }
    }

}
