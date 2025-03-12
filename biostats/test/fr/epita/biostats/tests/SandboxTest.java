package fr.epita.biostats.tests;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.services.BiostatCsvService;
import fr.epita.biostats.services.BiostatDataService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class SandboxTest {

    public static void main(String[] args) throws IOException {
        BiostatCsvService service = new BiostatCsvService();

        String theFileName = "biostats/biostat.csv";
        List<BiostatEntry> entries = service.importBiostatEntries(theFileName);
        //then do the reverse operation: save the entries in an other file
        String theContentToBeWritten = "";
        String anotherFileName = "export.csv";




        //Bonus : you have to compute the birth year from the age column
        // average age
        // average height
        // average weight
        // distribution according to the gender (how many men and women)?
        Double avgAge = 0.0;
        for(BiostatEntry entry : entries){
            avgAge = avgAge + entry.getAge();
        }
        avgAge = avgAge / entries.size();

        ToIntFunction<BiostatEntry> intFunction = BiostatEntry::getAge;
        Double averageAge = getAverageOfSomething(entries, BiostatEntry::getAge);

        Double averageHeight = getAverageOfSomething(entries, BiostatEntry::getHeight);

        BiostatDataService biostatDataService = new BiostatDataService();

        //some approaches to do the distribution
        //group by gender and count
        int Fcounter = 0;
        int Mcounter = 0;
        for (BiostatEntry biostatEntry : entries){
            if (biostatEntry.getSex().equals("F")){
                Fcounter +=1;
            } else if (biostatEntry.getSex().equals("M")) {
                Mcounter +=1 ;
            }
        }
        System.out.println("F entries count :" + Fcounter);
        System.out.println("M entries count :" + Mcounter);

        //using a map
        Map<String, Integer> countPerGender = new HashMap<>();

        for (BiostatEntry entry : entries){
            Integer i = countPerGender.get(entry.getSex());
            if (i == null){
                countPerGender.put(entry.getSex(), 1);
            } else {
                countPerGender.put(entry.getSex(), i + 1);
            }
        }

        //using the stream api
        Map<String, Long> groupByGenderCount = entries.stream()
                .collect(Collectors.groupingBy(BiostatEntry::getSex, Collectors.counting()));


        System.out.println(groupByGenderCount);

        service.exportBiostatEntries(anotherFileName, entries);



    }

    private static double getAverageOfSomething(List<BiostatEntry> entries, ToIntFunction<BiostatEntry> intFunction) {
        return entries.stream()
                .mapToInt(intFunction)
                .average()
                .getAsDouble();
    }

}
