package com.aqacourses.test.student;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractStudent {

    /**
     * Parse data from GUI
     *
     * @return list with student data
     */
    public List<String> parseData() {
        List<String> data = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter name of student:");
        String name = scanner.nextLine();
        if (isLineNotEmpty(name)) {
            data.add(name);
        }

        System.out.println("Please enter age of student:");
        String age = scanner.nextLine();
        if (isLineNotEmpty(age)) {
            data.add(age);
        }

        System.out.println("Please enter sex of student:");
        String sex = scanner.nextLine();
        if (isLineNotEmpty(sex)) {
            data.add(sex);
        }

        return data;
    }

    /**
     * Reading path to users file  from GUI
     *
     * @return string with path to Students from Pedin
     */
    public String fileLocation() {

        System.out.println("Please enter path to the file:");
        Scanner scanner = new Scanner(System.in);
        String pathToFile = scanner.nextLine();
        if (isLineNotEmpty(pathToFile)) {
            return pathToFile;
        }
        return "No such file or directory";
    }

    /**
     * Opens GUI
     */
    public void openGui() {
        System.out.println("Opened GUI");
    }

    /**
     * Verify that string is not empty
     *
     * @param line
     * @return
     */
    private boolean isLineNotEmpty(String line) {
        if (!line.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Get date
     *
     * @return string that represents current date and time
     */
    public String getDate() {
        return new SimpleDateFormat("YYYY-MM-dd HH:mm:ss")
                .format(Calendar.getInstance().getTime());
    }


}
