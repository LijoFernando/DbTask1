package manageDetails.manageDetails.logicLayer;
import manageDetails.manageDetails.PersistanceException.CustomizedException;
import manageDetails.manageDetails.persistence.PersistenceManager;

public class DataHandler {
    PersistenceManager persistenceManager = null;
    public void deleteCustomerFromDB(Integer cusId) throws CustomizedException {
        PersistenceManager.manipulateData();
    }
     public void testInterface() throws CustomizedException{
         PersistenceManager.manipulateData();

     }
}
