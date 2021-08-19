package manageDetails.manageDetails.persistence;

import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.pojo.*;

import java.util.List;

public interface PersistenceManager {

    List<AccountInfo> accountInfoRecords() throws CustomizedException;
    int[] persistCustomerList (List<Customer> customerArrayList) throws CustomizedException;
    String checkCustomerStatus(Integer cusID) throws CustomizedException;
    void insertAccountToDB(int[] cusID, List<AccountInfo> accountInfoArrayList) throws CustomizedException;
    void deleteCustomer(Integer cusId) throws CustomizedException;

}
