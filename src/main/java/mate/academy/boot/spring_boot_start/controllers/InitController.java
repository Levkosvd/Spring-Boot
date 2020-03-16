package mate.academy.boot.spring_boot_start.controllers;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
public class InitController {
    CSVReader csvReader;
    String[] nextline;
    List<String[]> reuslts = new ArrayList<>();

    {
        try {
            csvReader = new CSVReader(new FileReader("src/main/resources/Reviews.csv"));

            while ((nextline = csvReader.readNext()) != null) {
                if (nextline != null) {
                    //Verifying the read data here
                    reuslts.add(nextline);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
