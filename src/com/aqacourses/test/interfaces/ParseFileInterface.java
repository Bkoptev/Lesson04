package com.aqacourses.test.interfaces;

import java.util.ArrayList;

public interface ParseFileInterface {
    /**
     *
     * @param pathToFile receive path to file where are described students from Pedin
     * @return           ArrayList with all students
     */

    ArrayList ParseFile  (String pathToFile);
}
