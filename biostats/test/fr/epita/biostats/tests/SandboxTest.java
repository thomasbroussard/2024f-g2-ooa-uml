package fr.epita.biostats.tests;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.services.BiostatCsvService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SandboxTest {

    public static void main(String[] args) throws IOException {
        BiostatCsvService service = new BiostatCsvService();

        String theFileName = "biostats.csv";
        List<BiostatEntry> entries = service.importBiostatEntries(theFileName);
        //then do the reverse operation: save the entries in an other file
        String theContentToBeWritten = "";
        String anotherFileName = "export.csv";
        service.exportBiostatEntries(anotherFileName, entries);



        //Bonus : you have to compute the birth year from the age column
        // average age
        // average height
        // average weight
        // distribution according to the gender (how many men and women)?



    }

}
