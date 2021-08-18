package manageDetails.manageDetails.processor;

import manageDetails.manageDetails.BankException.CustomizedException;
import manageDetails.manageDetails.configuration.DataHandler;
import manageDetails.manageDetails.pojo.*;

import java.sql.Date;
import java.util.*;

public class CustomerProcessor {
        Scanner input = new Scanner(System.in);
        Customer customerInput = null;
        AccountInfoProcessor accountInfoProcessor;
        ArrayList<Customer> customerArrayList;
        ArrayList<AccountInfo> accountInfoArrayList;

        public void chooseNoOfCustomer() throws CustomizedException {
                System.out.print("Enter No of Record to insert: ");
                int noOfRecords = input.nextInt();
                int[] cusIDs = null;
                accountInfoProcessor = new AccountInfoProcessor();
                customerArrayList = new ArrayList<>();
                accountInfoArrayList = new  ArrayList<>();
                try {
                    for (int i = 0; i < noOfRecords; i++) {
                        this.customerInput(i);
                        accountInfoArrayList =  accountInfoProcessor.accountInput();
                    }
                    cusIDs = insertToDB(customerArrayList);
                    DataHandler.getPersistenceManager().insertAccountToDB(cusIDs,accountInfoArrayList);
                } catch (CustomizedException e){
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
            return DataHandler.getPersistenceManager().persistCustomerList(customerArrayList);
         }
}

