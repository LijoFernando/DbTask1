package manageDetails.manageDetails.processor;

import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.configuration.DataHandler;
import manageDetails.manageDetails.logicLayer.DataStoreHelper;
import manageDetails.manageDetails.pojo.AccountInfo;

import java.util.*;

public class AccountInfoProcessor {
    private static final Scanner input = new Scanner(System.in);
    private static AccountInfo accountInfo ;
    private static List<AccountInfo> accountInfoArrayList = new ArrayList<>();

    //Add AccountInformation for Existing Customer
    public static void addAccountForExistingCustomer() throws CustomizedException {
            System.out.println("Enter Customer ID: ");
           int [] cusID = new int[1];
           cusID[0]=input.nextInt();
           List<AccountInfo> accountInfoRecordList = AccountInfoProcessor.accountInput();
           DataHandler.getPersistenceManager().insertAccountToDB(cusID,accountInfoRecordList);
    }

    //save Account Information to arraylist from userInput
    public static List<AccountInfo> accountInput( ) throws CustomizedException{
        try {
            System.out.println("Enter Account Info of " );
            System.out.println("Enter the Account Number: ");
            long accNumber = input.nextLong();
            System.out.println("Enter the Account Balance: ");
            int accBalance = input.nextInt();
            input.nextLine();
            System.out.println("Enter the Branch Name: ");
                String accBranch = input.nextLine();
                accountInfo = new AccountInfo();
                accountInfo.setAccNo(accNumber);
                accountInfo.setAccBalance(accBalance);
                accountInfo.setAccBranch(accBranch);
                accountInfoArrayList.add(accountInfo);
        } catch (Exception e) {
            throw new CustomizedException("Enter Valid input", e);
        }
        return accountInfoArrayList;
    }
}


