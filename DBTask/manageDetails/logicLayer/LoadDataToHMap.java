package manageDetails.manageDetails.logicLayer;

import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.persistence.PersistenceManager;
import manageDetails.manageDetails.pojo.AccountInfo;

import java.util.*;

public class LoadDataToHMap {
    PersistenceManager pr;
    HashMap <Integer, HashMap<Long, AccountInfo> > outerHashMap = new HashMap<>();

    public LoadDataToHMap() throws CustomizedException {
        DataHandler dbHandler = new DataHandler();
        pr = dbHandler.getPersistenceManager();
    }

    public void loadHashMap() throws CustomizedException {
        //load hashMap from DB
        List<AccountInfo> dbArrayList = pr.accountInfoRecords();
        try {
            for (AccountInfo accountinfo : dbArrayList) {
                int cusId = accountinfo.getCusId();
                long accNo = accountinfo.getAccNo();
                HashMap<Long, AccountInfo> innerHashMap = outerHashMap.get(cusId);
                if (innerHashMap == null) {
                    innerHashMap = new HashMap<>();
                    outerHashMap.put(cusId, innerHashMap);
                }
                innerHashMap.put(accNo, accountinfo);
            }
        }
        catch (Exception e) {
            throw new CustomizedException("AccountInfo HashMap not loaded");
        }
    }

    public void loadSpecific(Integer cusId) throws CustomizedException {
        try {
            List<String> arrayList = new ArrayList<>();
            arrayList.add(outerHashMap.get(cusId).values().toString());
            System.out.println(arrayList);
        } catch (NullPointerException e){
            throw  new CustomizedException("Customer ID is Invalid");
        }
    }
}
