package com.aqacourses.test.student;

import com.aqacourses.test.interfaces.ParseFileInterface;
import com.aqacourses.test.interfaces.WriteToDbInterface;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class StudentPedin extends Student implements WriteToDbInterface, ParseFileInterface {

    private FileWriter fileWriter;
    private PrintWriter printWriter;

    /**
     * Write student data to MySQL Db
     *
     * @param data
     */
    @Override
    public void writeToDb(List<String> data) {
        try {
            openConnectionToDb();
            if (isDataValid(data)) {
                for (String datum : data) {
                    printWriter.println(getDate() + " - " + datum);
                }
                printWriter.print("=====================\n");
                System.out.println("All data is written to MySQL DB");
                closeConnectionToDb();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Open connection to MySQL DB
     */
    private void openConnectionToDb() throws IOException {
        String path = "D:/Java_lessons/Lesson04/MySQL-DB-Pedin.txt";
        fileWriter = new FileWriter(path);
        printWriter = new PrintWriter(fileWriter);
    }

    /**
     * CLose connection to MySQL DB
     */
    private void closeConnectionToDb() throws IOException {
        printWriter.close();
        fileWriter.close();
        System.out.println("Close connection to MySQL DB");
    }

    /**
     *
     * @param pathToFile receive path to file where are described students from Pedin
     * @return           list od Pedin students
     */
    @Override
    public ArrayList ParseFile (String pathToFile) {
        ArrayList<String> pedinStudents = new ArrayList<>();
        File file = new File(pathToFile);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (scan != null) {
            while (scan.hasNextLine()) {
                pedinStudents.add(scan.nextLine());
            }
        }
        return pedinStudents;
    }


}
