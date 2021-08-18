package manageDetails.manageDetails;

import manageDetails.manageDetails.logicLayer.*;

import manageDetails.manageDetails.BankException.CustomizedException;

import java.io.IOException;
import java.util.Scanner;

public class TaskRunner {
    public static void main(String[] args) throws IOException, CustomizedException {
        AddCustomer addCustomerDetail = new AddCustomer();
        AddAccountInfo addAccountInfo = new AddAccountInfo();
        //loaded HashMap From Database
        LoadDataToHMap syncHashMap = new LoadDataToHMap();
        try {
            syncHashMap.loadHashMap();
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
                "\n4.Print HashMap ");
        System.out.print("Enter ur choice: ");
        int choice = input.nextInt();

        if(choice == 1) {
            try {
                addCustomerDetail.chooseNoOfCustomer();
            }
            catch (CustomizedException e){
                System.out.println(e.getMessage());
            }
        }

        else if(choice == 2) {

            try {
                System.out.println("Enter your customer ID");
                int cusId = input.nextInt();
                addAccountInfo.addAccountForExistingCustomer(cusId);

            } catch(CustomizedException e) {
                System.out.println( e.getMessage());
            }
        }

        else if(choice == 3){
            System.out.println("Enter id: ");
            int cusId = input.nextInt();
            try {
                syncHashMap.loadSpecific(cusId);
            } catch(CustomizedException e) {
                System.out.println(e.getMessage());
            }
        }

        else if (choice == 4) {
            try {
                syncHashMap.loadHashMap();
            } catch(CustomizedException e) {
                System.out.println(e.getMessage());
            }
        }

        //Delete Customer From Database
        else if(choice == 5){
            System.out.println("Enter CustomerId to Delete");
            int cusId = input.nextInt();
            try{
                DataStoreHelper dataStoreHelper = new DataStoreHelper();
                dataStoreHelper.deleteCustomerInfo(cusId);
            } catch (CustomizedException e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        else {
            System.out.println("Enter Valid Choice");

        }
    }
}

