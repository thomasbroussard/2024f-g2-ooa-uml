package fr.epita.biostats.services;

import fr.epita.biostats.datamodel.BiostatEntry;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BiostatCsvService {


    public List<BiostatEntry> importBiostatEntries(String theFileName) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(theFileName));
        List<BiostatEntry> entries = new ArrayList<>();
        for (String line : lines){
            String[] parts = line.split(",");

            String cleanName = parts[0].replace("\"", "").trim();
            String cleanGender = parts[1].replace("\"", "").trim();
            String cleanAgeAsString = parts[2].replace("\"", "").trim();
            Integer cleanAge = Integer.parseInt(cleanAgeAsString);
            String cleanHeightAsString = parts[3].replace("\"", "").trim();
            Integer cleanHeight = Integer.parseInt(cleanAgeAsString);
            String cleanWeightAsString = parts[4].replace("\"", "").trim();
            Integer cleanWeight = Integer.parseInt(cleanAgeAsString);

            //map the array "parts" to a BiostatEntry instance

            BiostatEntry entry = new BiostatEntry(
                    cleanName,
                    cleanGender,
                    cleanAge,
                    cleanHeight,
                    cleanWeight
            );
            entries.add(entry);

        }
        return entries;
    }

    public void exportBiostatEntries(String anotherFileName, List<BiostatEntry> entries) {
        //TODO complete
        Files.writeString(Path.of("export.csv"),theContentToBeWritten);
    }
}
