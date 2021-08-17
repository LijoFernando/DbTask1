package manageDetails.manageDetails;

import manageDetails.manageDetails.PersistanceException.CustomizedException;
import manageDetails.manageDetails.persistence.DBOperation;
import manageDetails.manageDetails.pojo.AccountInfo;

import java.util.ArrayList;
import java.util.Scanner;

public class AddAccountInfo {
    Scanner input = new Scanner(System.in);
    DBOperation dbConnection = new DBOperation();
    AccountInfo accountInfo = new AccountInfo();
    ArrayList<AccountInfo> accountInfoArrayList = new ArrayList<>();
    public void addAccountForExistingCustomer(Integer cusID) throws CustomizedException {
        String status = dbConnection.checkCustomerStatus(cusID);
        if(status != "Inactive") {
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
        public void insertAccountDB(int[] cusId,ArrayList<AccountInfo> accountInfoArrayList) throws CustomizedException {
            dbConnection.insertAccountToDB(cusId,accountInfoArrayList);
        }
    }


