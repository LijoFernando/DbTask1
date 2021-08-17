package manageDetails.manageDetails.persistence;

import manageDetails.manageDetails.PersistanceException.CustomizedException;
import manageDetails.manageDetails.pojo.AccountInfo;
import manageDetails.manageDetails.pojo.Customer;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public interface PersistenceManager {
   static void manipulateData() throws CustomizedException{

       Class classDb;
       try {
           classDb = Class.forName("manageDetails.manageDetails.persistence.DBOperation");
           Method methodList[] = classDb.getMethods();
           for (Method m: methodList ) {
//               Method singleMethod = classDb.getMethod(m.getName());
               Parameter[] parameter = m.getParameters();
               System.out.println(m.getName());
               for (Parameter p:parameter) {
                   System.out.println(p);
               }

           }

       } catch (Throwable e){
           e.printStackTrace();
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
