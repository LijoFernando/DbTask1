package manageDetails.manageDetails;

import manageDetails.manageDetails.dbLayer.DBOperation;
import manageDetails.manageDetails.logicLayer.*;

import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.persistence.PersistenceManager;
import manageDetails.manageDetails.processor.*;

import java.io.IOException;
import java.util.Scanner;

public class TaskRunner {
    public static void main(String[] args) throws IOException, CustomizedException {
        //loaded HashMap From Database

        try {
            LoadDataToHMap.loadHashMap();
            PersistenceManager pM = new DBOperation();
        } catch(CustomizedException e) {
            e.printStackTrace();
            e.getCause();
            System.out.println(e.getMessage());
        }

        //Choose the Operation to do!!
        Scanner input = new Scanner(System.in);
        System.out.println("Select from (1-3)" +
                "\n1.Add new Customer. " +
                "\n2.Add Bank Detail for Existing Customer. " +
                "\n3.get AccountInfo of customer from HMap"+
                "\n4.Print HashMap " +
                "\n5.check Customer Active Status"
        );
        System.out.print("Enter ur choice: ");
        int choice = input.nextInt();
        if(choice == 1) {
            try {
                CustomerProcessor.chooseNoOfCustomer();
            }
            catch (CustomizedException e){
                System.out.println(e.getMessage());
            }
        }
        else if(choice == 2) {
            AccountInfoProcessor.addAccountForExistingCustomer();
        }
        else if(choice == 3){
            System.out.println("Enter id: ");
            int cusId = input.nextInt();
            try {
               LoadDataToHMap.getSpecificCustomerAccount(cusId);
            } catch(CustomizedException e) {
                System.out.println(e.getMessage());
            }
        }
        //Add account for Existing Customer
        else if(choice == 4){
            System.out.println("Enter CusID");
            int cusID =input.nextInt();
          DataStoreHelper.checkCustomer(cusID);
        }
        else {
            System.out.println("Enter Valid Choice");

        }
    }
}

