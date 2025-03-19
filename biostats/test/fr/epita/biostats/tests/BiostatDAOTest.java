package fr.epita.biostats.tests;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.services.db.BiostatDAO;

import java.sql.SQLException;
import java.util.List;

public class BiostatDAOTest {

    public static void main(String[] args) throws SQLException {
      //  testUpdate();
        BiostatDAO biostatDAO = new BiostatDAO();

        BiostatEntry referenceEntry = new BiostatEntry("test", "M", 22, 170, 75);
        BiostatEntry otherEntry = new BiostatEntry("testF", "F", 25, 190, 70);
        biostatDAO.create(referenceEntry);
        biostatDAO.create(otherEntry);

        List<BiostatEntry> entries = biostatDAO.readAll();
        System.out.println(entries.size());

        entries = biostatDAO.search(new BiostatEntry(null, "F", null, null, null));

        System.out.println(entries);

        biostatDAO.delete(referenceEntry);

        entries = biostatDAO.readAll();

        System.out.println(entries.size());




    }

    private static void testUpdate() throws SQLException {
        //context preparation
        BiostatDAO biostatDAO = new BiostatDAO();

        BiostatEntry referenceEntry = new BiostatEntry("test", "M", 22, 170, 75);
        biostatDAO.create(referenceEntry);
        List<BiostatEntry> entries = biostatDAO.readAll();
        System.out.println(entries.get(0).getWeight());

        //update check
        BiostatEntry updatedRecord = new BiostatEntry("test", "M", 22, 170, 70);
        biostatDAO.update(updatedRecord);

        entries = biostatDAO.readAll();

        System.out.println(entries.get(0).getWeight());
    }
}
