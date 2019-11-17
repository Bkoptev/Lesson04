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
     * Write student data to MS-SQL-DB
     *
     * @param data list of students from pedin file
     */
    @Override
    public void writeToDb(List<String> data) {
        try {
            openConnectionToDb();
            for (int i = 0; i < data.size(); i++) {
                ArrayList studentData = new ArrayList();
                studentData.add(data.get(i));
                if (isDataValid(studentData) && validator(studentData)) {

                        printWriter.println(getDate() + " - " + studentData);

                }
            }
            printWriter.print("=====================\n");
            System.out.println("All data is written to MS-SQL-DB");
            closeConnectionToDb();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Open connection to MS-SQL-DB
     */
    private void openConnectionToDb() throws IOException {
        String path = "MS-SQL-DB.txt";
        fileWriter = new FileWriter(path);
        printWriter = new PrintWriter(fileWriter);
    }

    /**
     * CLose connection to MS-SQL-DB
     */
    private void closeConnectionToDb() throws IOException {
        printWriter.close();
        fileWriter.close();
        System.out.println("Close connection to MS-SQL-DB");
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
            System.out.println("No such file or directory");
        }

        if (scan != null) {

            while (scan.hasNextLine()) {
                pedinStudents.add(scan.nextLine());
                }
            }

        return pedinStudents;
    }
}
