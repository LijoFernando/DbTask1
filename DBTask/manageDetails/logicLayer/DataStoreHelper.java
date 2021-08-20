package manageDetails.manageDetails.logicLayer;

import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.configuration.DataHandler;
import manageDetails.manageDetails.pojo.AccountInfo;
import manageDetails.manageDetails.pojo.Customer;

import java.util.List;

public class DataStoreHelper {

            //Check Customer Active or NOT

            public static void checkCustomer(Integer cusID) throws CustomizedException{
                Customer customer = LoadDataToHMap.getCustomerHMap().get(cusID);
                String status = customer.getCusStatus();
                System.out.println(status);

            }

//            //Delete CustomerInfo From Database Layer
//            public static void deleteExistingCustomer(Integer cusID) throws CustomizedException {
//                int customerStatus = DataStoreHelper.checkCustomer(cusID);
//                if (customerStatus == 1) {
//                    DataHandler.getPersistenceManager().deleteCustomer(cusID);
//                }
//            }
//
//
//            public static void addAccountForExistingCustomer(Integer cusID, List<AccountInfo> accountRecordList) throws CustomizedException {
//               if (DataStoreHelper.checkCustomer(cusID)==1){
//                    // DataHandler.getPersistenceManager().insertAccountToDB(cusID ,accountRecordList);
//               }
//            }
}
