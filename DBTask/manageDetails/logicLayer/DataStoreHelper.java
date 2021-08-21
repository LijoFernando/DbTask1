package manageDetails.manageDetails.logicLayer;

import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.configuration.DataHandler;
import manageDetails.manageDetails.pojo.AccountInfo;
import manageDetails.manageDetails.pojo.Customer;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class DataStoreHelper {

            //Delete CustomerInfo From Database
            public static void deleteExistingCustomer(Integer cusID) throws CustomizedException{
                if (!LoadDataToHMap.deletedList.contains(cusID)) {
                        DataHandler.getPersistenceManager().deleteCustomer(cusID);
                }
            }


}
