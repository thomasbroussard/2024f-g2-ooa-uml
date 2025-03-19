package fr.epita.biostats.tests;

import fr.epita.biostats.datamodel.BiostatEntry;
import fr.epita.biostats.services.db.BiostatDAO;
import fr.epita.biostats.services.exception.CreationException;

import java.sql.SQLException;
import java.util.List;

public class BiostatDAOTest {

    public static void main(String[] args) throws SQLException {
      //  testUpdate();
        BiostatDAO biostatDAO = new BiostatDAO();

        BiostatEntry referenceEntry = new BiostatEntry("test", "M", 22, 170, 75);
        BiostatEntry otherEntry = new BiostatEntry("testF", "F", 25, 190, 70);
        try {
            biostatDAO.create(referenceEntry);
            biostatDAO.create(otherEntry);
            biostatDAO.create(new BiostatEntry("TestError", "Female", 23, 180, 67));
        }catch (CreationException creationException){
            //something to display to the user in that case
            creationException.printStackTrace();
        }
        List<BiostatEntry> entries = biostatDAO.readAll();
        System.out.println(entries.size());

        entries = biostatDAO.search(new BiostatEntry(null, "F", null, null, null));

        System.out.println(entries);

        biostatDAO.delete(referenceEntry);

        entries = biostatDAO.readAll();

        System.out.println(entries.size());




    }

    private static void testUpdate() throws SQLException, CreationException {
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
