package manageDetails.manageDetails.processor;

import com.mysql.cj.util.DnsSrv;
import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.configuration.DataHandler;
import manageDetails.manageDetails.logicLayer.DataStoreHelper;
import manageDetails.manageDetails.pojo.AccountInfo;

import java.util.*;

public class AccountInfoProcessor {
    private static Scanner input = new Scanner(System.in);
    private static AccountInfo accountInfo = new AccountInfo();
    private static ArrayList<AccountInfo> accountInfoArrayList = new ArrayList<>();

    //Add AccountInformation for Existing Customer
    public static void addAccountForExistingCustomer() throws CustomizedException {
           System.out.println("Enter Customer ID: ");
           int cusID = input.nextInt();
           ArrayList<AccountInfo> accountInfoRecordList = AccountInfoProcessor.accountInput();
           DataStoreHelper.addAccountForExistingCustomer(cusID, accountInfoRecordList);
    }

    //save Account Information to arraylist from userInput
    public static ArrayList<AccountInfo> accountInput( ) throws CustomizedException{
        try {
            System.out.println("Enter Account Info of " );
            System.out.println("Enter the Account Number: ");
            long accNumber = input.nextLong();
            System.out.println("Enter the Account Balance: ");
            int accBalance = input.nextInt();
            input.nextLine();
            System.out.println("Enter the Branch Name: ");
            String accBranch = input.nextLine();
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


