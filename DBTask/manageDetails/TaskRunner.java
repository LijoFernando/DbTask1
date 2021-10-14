package manageDetails.manageDetails;

import manageDetails.manageDetails.dbLayer.DBOperation;
import manageDetails.manageDetails.logicLayer.*;

import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.persistence.PersistenceManager;
import manageDetails.manageDetails.processor.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskRunner {
    public static void main(String[] args) throws IOException, CustomizedException {
        //loaded HashMap From Database

        try {
            LoadDataToHMap.loadHashMap();
            LoadDataToHMap.deletedCustomer();
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
                "\n3.get Specific customer AccountInfo from HMap"+
                "\n4.Delete Existing Customer " +
                "\n5.Make Transaction "
        );
        System.out.print("Enter ur choice: ");
        int choice = input.nextInt();
        while(true) {
            switch (choice) {
                case 1:
                    try {
                        CustomerProcessor.chooseNoOfCustomer();
                    } catch (CustomizedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case  2:
                    AccountInfoProcessor.addAccountForExistingCustomer();
                    break;

                case  3:
                    System.out.println("Enter id: ");
                    int cusId = input.nextInt();
                    try {
                        LoadDataToHMap.getSpecificCustomerAccount(cusId);
                    } catch (CustomizedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                //Add account for Existing Customer
                case 4:
                    System.out.println("Enter CusID");
                    int cusID = input.nextInt();
                    DataStoreHelper.deleteExistingCustomer(cusID);
                    break;

                case 5:
                    System.out.println("Enter CusId");
                    cusId = input.nextInt();
                    System.out.println("Enter AccountNo");
                    long accNo = input.nextLong();
                    System.out.println("Enter Transaction Type(deposit or withdraw)");
                    input.nextLine();
                    String transactType = input.nextLine();
                    System.out.println("Enter the amount");
                    int amount = input.nextInt();
                    if (!DataStoreHelper.transactionDataValidator(cusId, accNo, transactType, amount)) {
                        System.out.println("Enter Valid Input");
                        return;
                    }
                    //AccountNo,TransactType,Amount,CusId
                    List<String> transactionData = new ArrayList<>();
                    transactionData.add(String.valueOf(accNo));
                    transactionData.add(transactType);
                    transactionData.add(String.valueOf(amount));
                    transactionData.add(String.valueOf(cusId));
                    DataStoreHelper.makeTransaction(transactionData);
                    break;

                case 0:
                    System.out.println("Exited");
                    System.exit(0);
            }
        }

    }
}

