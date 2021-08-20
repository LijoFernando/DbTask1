package manageDetails.manageDetails.logicLayer;

import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.configuration.DataHandler;
import manageDetails.manageDetails.pojo.AccountInfo;
import manageDetails.manageDetails.pojo.Customer;

import java.util.*;

public class LoadDataToHMap {
    //Customer Information
    private static Map <Integer, Customer> customerInfoHashMap = new HashMap<>();
    //Customer Account Information
    private static Map <Integer, HashMap<Long, AccountInfo> > accountInfoHashMap = new HashMap<>();

    //load All data to HashMap
    public static void loadHashMap() throws CustomizedException {

        //ArrayList of customer and Account Details
        List <Customer> customerInfoList = DataHandler.getPersistenceManager().customerInfoRecords();
        List <AccountInfo> accountInfoList = DataHandler.getPersistenceManager().accountInfoRecords();
        try {
            for (Customer customerInfo: customerInfoList){
                int cusId = customerInfo.getCusID();
                customerInfoHashMap.put(cusId,customerInfo);
            }

            System.out.println(customerInfoHashMap);
            for (AccountInfo accInfo : accountInfoList) {
                int cusId = accInfo.getCusId();
                long accNo = accInfo.getAccNo();
                HashMap<Long, AccountInfo> innerHashMap = accountInfoHashMap.computeIfAbsent(cusId, k -> new HashMap<>());
                innerHashMap.put(accNo, accInfo);
            }
            System.out.println(accountInfoHashMap.entrySet());
        }
        catch (Exception e) {
            throw new CustomizedException("AccountInfo HashMap not loaded");
        }
    }

    //Get Account Details For Specific Customer
    public static List<String> getSpecificCustomerAccount(Integer cusId) throws CustomizedException {
        try {
            List <String> specificAccountList = new ArrayList<>();
            specificAccountList.add(accountInfoHashMap.get(cusId).values().toString());
            System.out.println(specificAccountList);
            return specificAccountList ;
        } catch (NullPointerException e){
            throw  new CustomizedException("Customer ID is Invalid");
        }
    }

    public static Map<Integer,Customer> getCustomerHMap(){
        if(customerInfoHashMap!=null) {
            return customerInfoHashMap;
        }
        return null;
    }
//    public static Boolean isActive(Integer cusId) {
//        HashMap<Long,AccountInfo> innerHasMap = outerHashMap.get(cusId);
//
//        return true;
//    }
}
