package manageDetails.manageDetails.logicLayer;

import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.configuration.DataHandler;
import manageDetails.manageDetails.persistence.PersistenceManager;
import manageDetails.manageDetails.pojo.AccountInfo;
import manageDetails.manageDetails.pojo.Customer;
import manageDetails.manageDetails.pojo.Transaction;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataStoreHelper {

    //Delete CustomerInfo From Database
    public static void deleteExistingCustomer(Integer cusID) throws CustomizedException {
        if (!LoadDataToHMap.deletedList.contains(cusID)) {
            DataHandler.getPersistenceManager().deleteCustomer(cusID);
        }
    }

    public static boolean transactionDataValidator(int cusId, long accountNo, String transactType, int amount) throws CustomizedException {
        if (cusId != 0 && accountNo != 0 && transactType != null && amount != 0) {
            if(transactType!=" withdraw" && transactType !="deposit"){
                return false;
            }
            System.out.println("Validate Input Success");
            return  true;
        } else {
            return false;
        }
    }

    //AccountNo,TransactType,Amount,CusId
    public static void makeTransaction(List<String> transactData) throws CustomizedException {
        Long accNo = Long.parseLong(transactData.get(0));
        String transactionType = transactData.get(1);
        Integer amount = Integer.parseInt(transactData.get(2));
        Integer cusId = Integer.parseInt(transactData.get(3));
        Transaction transaction = new Transaction();
        transaction.setAccountNo(accNo);
        transaction.setTransactionType(transactionType);
        transaction.setTimeOfTransaction(getTimeStamp());
        transaction.setAmount(amount);
        transaction.setCusId(cusId);
        System.out.println("transaction added");
        DataHandler.getPersistenceManager().makeTransaction(transaction);
    }

    public static String getTimeStamp() {
        String timeStamp = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        timeStamp = formatter.format(date);
        return timeStamp;
    }


}
