package fr.epita.biostats.tests;

import fr.epita.biostats.datamodel.BiostatEntry;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SandboxTest {

    public static void main(String[] args) {
        String line =  "\"Alex\",       \"M\",   41,       74,      170";

        String[] parts = line.split(",");

        String cleanName = parts[0].replace("\"", "").trim();
        String cleanGender = parts[1].replace("\"", "").trim();
        String cleanAgeAsString = parts[2].replace("\"", "").trim();
        Integer cleanAge = Integer.parseInt(cleanAgeAsString);
        String cleanHeightAsString = parts[3].replace("\"", "").trim();
        Integer cleanHeight = Integer.parseInt(cleanAgeAsString);
        String cleanWeightAsString = parts[4].replace("\"", "").trim();
        Integer cleanWeight = Integer.parseInt(cleanAgeAsString);

        System.out.println(cleanName);


        System.out.println(cleanHeight);

        //map the array "parts" to a BiostatEntry instance

        BiostatEntry entry = new BiostatEntry(
                cleanName,
                cleanGender,
                cleanAge,
                cleanHeight,
                cleanWeight
        );

        List<String> lines = Files.readAllLines(Path.of("biostats.csv"));
        List<BiostatEntry> entries;
        for (String currentLine : lines){

        }

        //then do the reverse operation: save the entries in an other file
        String theContentToBeWritten = "";
        Files.writeString(Path.of("export.csv"),theContentToBeWritten);


        //Bonus : you have to compute the birth year from the age column


    }
}
