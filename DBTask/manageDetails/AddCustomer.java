package manageDetails.manageDetails;

import manageDetails.manageDetails.PersistanceException.CustomizedException;
import manageDetails.manageDetails.persistence.DBOperation;
import manageDetails.manageDetails.pojo.AccountInfo;
import manageDetails.manageDetails.pojo.Customer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class AddCustomer {
        Scanner input = new Scanner(System.in);
        Customer customerInput = null;
        AddAccountInfo addAccountInfo ;
        DBOperation dbOperation = new DBOperation();
        ArrayList<Customer> customerArrayList;
        ArrayList<AccountInfo> accountInfoArrayList;


        public void chooseNoOfCustomer() throws CustomizedException {
                System.out.print("Enter No of Record to insert: ");
                int noOfRecords = input.nextInt();
                int[] cusIDs = null;
                addAccountInfo = new AddAccountInfo();
                customerArrayList = new ArrayList<>();
                accountInfoArrayList =new  ArrayList<>();
                try {
                    for (int i = 0; i < noOfRecords; i++) {
                        this.customerInput(i);
                        accountInfoArrayList =  addAccountInfo.accountInput();
                    }
                    cusIDs = insertToDB(customerArrayList);
                    addAccountInfo.insertAccountDB(cusIDs,accountInfoArrayList);

                }  catch (CustomizedException e){
                    throw new CustomizedException("Input Failure: Invalid Customer List");
                }
        }

        private void customerInput(Integer nthRecord) throws CustomizedException {
                try {
                    input.nextLine();
                    System.out.println("Enter Customer Details of : "+(nthRecord+1));
                    System.out.println("Enter Customer Name: ");
                    String name = input.nextLine();
                    System.out.println("Enter Customer Date of Birth(example: 2000-12-3): ");
                    String dateOfBirth = input.nextLine();
                    Date date1 = Date.valueOf(dateOfBirth);
                    long date = date1.getTime();
                    System.out.println("Enter Customer Location: ");
                    String location = input.nextLine();

                    customerInput = new Customer();
                    customerInput.setName(name);
                    customerInput.setDofBirth(date);
                    customerInput.setLocation(location);
                    customerArrayList.add(customerInput);

                } catch (IllegalArgumentException e) {
                    throw new CustomizedException("Input format is not valid",e);
                } catch (NullPointerException e) {
                    throw new CustomizedException("Fill Empty Field");
                }
        }

        public int[] insertToDB (ArrayList<Customer> customerArrayList) throws CustomizedException {
            return dbOperation.insertDetailToDB(customerArrayList);
         }
}

