package manageDetails.manageDetails.logicLayer;

import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.configuration.DataHandler;

import java.util.ArrayList;

public class DataStoreHelper {

            //Check Customer Active or NOT
            public static Integer checkCustomer(Integer cusID) throws CustomizedException{
                String customerStatus = DataHandler.getPersistenceManager().checkCustomerStatus(cusID);
                int flag = 0;
                if(customerStatus.equals("Active")) {
                    flag = 1;
                } return flag;
            }

            //Delete CustomerInfo From Database Layer
            public static void deleteExistingCustomer(Integer cusID) throws CustomizedException {
                int customerStatus = DataStoreHelper.checkCustomer(cusID);
                if(customerStatus == 1) {
                    DataHandler.getPersistenceManager().deleteCustomer(cusID);
                }
            }

            public static void addAccountForExistingCustomer(Integer cusID, ArrayList accountRecordList) throws CustomizedException {
               if(DataStoreHelper.checkCustomer(cusID)==1){
                    // DataHandler.getPersistenceManager().insertAccountToDB(cusID ,accountRecordList);
               }

            }

}
