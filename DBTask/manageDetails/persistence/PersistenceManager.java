package manageDetails.manageDetails.persistence;

import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.pojo.*;

import java.util.List;

public interface PersistenceManager {

    List<Customer> customerInfoRecords() throws CustomizedException;
    List<AccountInfo> accountInfoRecords() throws CustomizedException;
    int[] persistCustomerList (List<Customer> customerArrayList) throws CustomizedException;
    void insertAccountToDB(int[] cusID, List<AccountInfo> accountInfoArrayList) throws CustomizedException;
    void deleteCustomer(Integer cusId) throws CustomizedException;

}
