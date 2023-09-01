package org.matveyvs;

import junit.framework.TestCase;

import java.io.*;
import java.util.ArrayList;

public class JakartaTest extends TestCase {

    public void testWriteAndReadFromJsonAndUpdateTechnologyTest() {
        Technology technology = new Technology("First Technology", "Test case");
        Jakarta writeJakarta = new Jakarta("1", "JsonTest", new ArrayList<>());
        writeJakarta.getListOfTechnology().add(technology);

        int writeTechnologySize = writeJakarta.getListOfTechnology().size();

        String firstLine;
        File file = new File("/Users/matvey/MyProjects/first-maven-project/src/main/resources/fileWithPath.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            firstLine = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writeJakarta.writeToJson(firstLine);
        Jakarta readJakarta = Jakarta.readFromJson(firstLine);

        int readTechnologySize = readJakarta.getListOfTechnology().size();

        assertEquals(writeJakarta.getVersion(), readJakarta.getVersion());
        assertEquals(writeJakarta.getDescription(), readJakarta.getDescription());
        assertEquals(writeTechnologySize, readTechnologySize);

        for (int i = 0; i < writeTechnologySize; i++) {
            assertEquals(writeJakarta.getListOfTechnology().get(i).getName(),
                    readJakarta.getListOfTechnology().get(i).getName());
            assertEquals(writeJakarta.getListOfTechnology().get(i).getDescription(),
                    readJakarta.getListOfTechnology().get(i).getDescription());
        }

        //Update Technology test
        Technology testTechnology = new Technology("First Technology", "Test Passed");
        Jakarta testTechnologyJakarta = Jakarta.readFromJson(firstLine);

        int size = testTechnologyJakarta.getListOfTechnology().size();

        int indexOfUpdate = 0;

        for (int i = 0; i < size; i++){
            if (readJakarta.getListOfTechnology().get(i).getName().equals(testTechnology.getName())){
                testTechnologyJakarta.updateTechnology(testTechnology);
                indexOfUpdate = i;
            }
        }
        //Finally write to file
        testTechnologyJakarta.writeToJson(firstLine);

        assertEquals(testTechnology.getDescription(), testTechnologyJakarta.getListOfTechnology().get(indexOfUpdate).getDescription());

    }
}