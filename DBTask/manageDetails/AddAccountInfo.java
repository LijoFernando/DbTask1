package manageDetails.manageDetails;

import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.logicLayer.DataHandler;
import manageDetails.manageDetails.persistence.PersistenceManager;
import manageDetails.manageDetails.pojo.AccountInfo;

import java.util.*;

public class AddAccountInfo {
    Scanner input = new Scanner(System.in);
    AccountInfo accountInfo = new AccountInfo();
    ArrayList<AccountInfo> accountInfoArrayList = new ArrayList<>();



    public void addAccountForExistingCustomer(Integer cusID) throws CustomizedException {
        PersistenceManager pr = DataHandler.
        String status =  .checkCustomerStatus(cusID);
        if(status.equals("Active")) {
            System.out.println(status);

        } else {
            System.out.println("Customer Record Deleted");
        }
    }

    public ArrayList<AccountInfo> accountInput( ) throws CustomizedException{
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


