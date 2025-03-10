package fr.epita.biostats.tests;

public class SandboxTest {

    public static void main(String[] args) {
        String line =  "\"Alex\",       \"M\",   41,       74,      170";

        String[] parts = line.split(",");

        String cleanName = parts[0].replace("\"", "");

        System.out.println(cleanName);

        String cleanHeight = parts[3].trim();

        System.out.println(cleanHeight);
        System.out.println(Integer.parseInt(cleanHeight));

        //map the array "parts" to a BiostatEntry instance
    }
}
