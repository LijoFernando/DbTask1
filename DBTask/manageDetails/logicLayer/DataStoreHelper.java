package manageDetails.manageDetails.logicLayer;

import manageDetails.manageDetails.BankException.CustomizedException;

public class DataStoreHelper {
            //Delete CustomerInfo From Database Layer
            public String deleteCustomerInfo(Integer cusId) throws CustomizedException {
               String message =  DataHandler.getPersistenceManager().deleteCustomer(cusId);
               return message;
            }
}
