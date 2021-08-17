package manageDetails.manageDetails.persistence;

import manageDetails.manageDetails.PersistanceException.CustomizedException;
import manageDetails.manageDetails.pojo.AccountInfo;
import manageDetails.manageDetails.pojo.Customer;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

public interface PersistenceManager {
   static void manipulateData() throws CustomizedException{
       Map <String,>
       Class classDb;
       try {
           classDb = Class.forName("manageDetails.manageDetails.persistence.DBOperation");
           Method methodList[] = classDb.getDeclaredMethods();
           for (Method m:methodList) {
               System.out.println(m.getName());
           }

       } catch (ClassNotFoundException e){
           throw new CustomizedException("Class not Found");
       }
   }


//    ArrayList<AccountInfo> accountInfoRecords() throws CustomizedException;
//
//    int[] insertDetailToDB (ArrayList<Customer> customerArrayList) throws CustomizedException;
//
//    String checkCustomerStatus(Integer cusID) throws CustomizedException;
//
//    void insertAccountToDB(int[] cusID, ArrayList<AccountInfo> accountInfoArrayList) throws CustomizedException;
//
//    String deleteCustomer(Integer cusId) throws CustomizedException;

}
