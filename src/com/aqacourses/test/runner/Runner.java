package com.aqacourses.test.runner;

import com.aqacourses.test.student.Student;
import com.aqacourses.test.student.StudentMogilyanka;
import com.aqacourses.test.student.StudentNki;
import com.aqacourses.test.student.StudentPedin;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    /**
     * Add some student to DBs
     *
     * @param args
     */
    public static void main(String[] args) {

        // Create instance of NKI student
        StudentNki studentNki = new StudentNki();

        // Imagine that GUI opens
        studentNki.openGui();

        // Parse data
        List<String> data = studentNki.parseData();

        // Write data to 'DB'
        studentNki.writeToDb(data);

        // Clear list for reusing
        data.clear();

        // Create instance of Mogilyanka student
        StudentMogilyanka studentMogilyanka = new StudentMogilyanka();

        // Imagine that GUI opens one more time
        studentMogilyanka.openGui();

        // Parse data again
        data = studentMogilyanka.parseData();

        // Write data to another 'DB'
        studentMogilyanka.writeToDb(data);

        data.clear();

        // Imagine that GUI opens one more time

        ArrayList dataPedin = new ArrayList<>();

        StudentPedin studentPedin = new StudentPedin();

        studentPedin.openGui();

        //Typing path to file where are students from Pedin

        String pathToFile = studentPedin.fileLocation();

        // Parse data from file

        dataPedin = studentPedin.ParseFile(pathToFile);

        // Write data to another 'DB'

        studentPedin.writeToDb(dataPedin);

        // It's possible to create instance of class in that way
        // using inheritance
        Student student1 = new StudentMogilyanka();
        Student student2 = new StudentNki();
    }

    // Overloading as is
    private void setId(int id) {

    }

    private void setId(String id) {

    }

    private void setId(String idString, int id) {

    }

    private void setId() {

    }

}
