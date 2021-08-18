package manageDetails.manageDetails.logicLayer;

import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.persistence.PersistenceManager;


public class DataStoreHelper {

            //Delete CustomerInfo From Database Layer
            public String deleteCustomerInfo(Integer cusId) throws CustomizedException {
               String message =  .deleteCustomer(cusId);
               return message;
            }
}
