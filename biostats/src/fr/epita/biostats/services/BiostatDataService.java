package fr.epita.biostats.services;

import fr.epita.biostats.datamodel.BiostatEntry;

import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class BiostatDataService {

    // average age
    // average height
    // average weight
    // distribution according to the gender (how many men and women)?

    public Double computeAverageAge(List<BiostatEntry> biostatEntries){
        return getAverageOfSomething(biostatEntries, BiostatEntry::getAge);
    }
    public Double computeAverageHeight(List<BiostatEntry> biostatEntries){
        return getAverageOfSomething(biostatEntries, BiostatEntry::getHeight);
    }
    public Double computeAverageWeight(List<BiostatEntry> biostatEntries){
        return getAverageOfSomething(biostatEntries, BiostatEntry::getWeight);
    }

    public Map<String, Long> getGenderDistribution(List<BiostatEntry> entries){
        return entries.stream()
                .collect(Collectors.groupingBy(BiostatEntry::getSex, Collectors.counting()));
    }

    private static double getAverageOfSomething(List<BiostatEntry> entries, ToIntFunction<BiostatEntry> intFunction) {
        return entries.stream()
                .mapToInt(intFunction)
                .average()
                .getAsDouble();
    }


}
