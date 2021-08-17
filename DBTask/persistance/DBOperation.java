package manageDetails.persistance;

import manageDetails.PersistanceException.CustomizedException;
import manageDetails.pojo.AccountInfo;
import manageDetails.pojo.Customer;

import javax.swing.plaf.nimbus.State;
import  java.sql.*;
import java.util.ArrayList;

public class DBOperation {
    private Connection con;

    private void loadConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "Root@123");
    }

    public Connection getConnection() throws SQLException {
        if (con == null) {
            loadConnection();
        }
        return con;
    }

    //Query
    private String selectAllRecordsFromAccountInfo = "SELECT * FROM AccountInfo";
    private String insertRecordsToCustomerTable = "insert into CustomerInfo (CusName, CusDoB, Location) values (?, ?, ?)";
    private String insertRecordsToAccountInfoTable = "insert into AccountInfo (AccNumber, AccBalance, Branch, CusID ) values (?, ?, ?,?)";

    public ArrayList<AccountInfo> accountInfoRecords() throws CustomizedException {
        ArrayList<AccountInfo> accountInfoArray = new ArrayList<>();
        try {
            PreparedStatement ps  = getConnection().prepareStatement(selectAllRecordsFromAccountInfo);
            ResultSet rs  = ps.executeQuery();
                try {
                    while (rs.next()) {
                        AccountInfo accountInfo = new AccountInfo();
                        accountInfo.setAccId(rs.getInt(1));
                        accountInfo.setAccNo(rs.getLong(2));
                        accountInfo.setAccBalance(rs.getInt(3));
                        accountInfo.setAccBranch(rs.getString(4));
                        accountInfo.setCusId(rs.getInt(5));
                        accountInfoArray.add(accountInfo);
                    }
                } finally {
                    rs.close();
                    ps.close();
                }
        } catch (SQLException e) {
            throw new CustomizedException("Account HashMap Loading is Unsuccessful,Invalid Query!!");
        }
    return accountInfoArray;
    }

    //insert Customer Info to Database
    public int[] insertDetailToDB (ArrayList<Customer> customerArrayList) throws CustomizedException {
        ResultSet rs = null;
        try {
            PreparedStatement ps = getConnection().prepareStatement(insertRecordsToCustomerTable, Statement.RETURN_GENERATED_KEYS);
            int[] cusId = new int[customerArrayList.size()];
            try {
                for (int i = 0; i < customerArrayList.size(); i++) {
                    Customer customer = customerArrayList.get(i);
                    String name = customer.getName();
                    long date = customer.getDofBirth();
                    String location = customer.getLocation();
                    ps.setString(1, name);
                    ps.setLong(2, date);
                    ps.setString(3, location);
                    ps.addBatch();
                }
                ps.executeBatch();
                rs = ps.getGeneratedKeys();
                int i = 0;
                while(rs.next()) {
                    cusId[i]= rs.getInt(1);
                    i++;
                }
                return cusId; //return Customers ID
            } catch (SQLException e) {
                throw new CustomizedException("SQL Exception", e);
            } finally {
                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            throw new CustomizedException("Customer Records Submission Unsuccessful", e);
        }

    }
    //customer Check (Active or Inactive)
    public String checkCustomerStatus(Integer cusID) throws CustomizedException{
        String query ="select CusStatus from CustomerInfo Where CusId = "+cusID+"";
        ResultSet rs = null;
        try {
            PreparedStatement ps = getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            String status = null;
            while(rs.next()){
                status = rs.getString(1);
            }
            return status;
        }catch (SQLException e){
            throw new CustomizedException("Database Connection Error While Checking Customer");
        }
    }
    //Insert AccountInfo to Database
    public void insertAccountToDB(int[] cusID, ArrayList<AccountInfo> accountInfoArrayList) throws CustomizedException {
            try {
                PreparedStatement ps =  getConnection().prepareStatement(insertRecordsToAccountInfoTable);
                try {
                    for (int i = 0; i < accountInfoArrayList.size(); i++) {
                        AccountInfo accountInfo = accountInfoArrayList.get(i);
                        long accNo = accountInfo.getAccNo();
                        int accBalance = accountInfo.getAccBalance();
                        String accBranch = accountInfo.getAccBranch();
                        int cusId = cusID[i];
                        ps.setLong(1, accNo);
                        ps.setInt(2, accBalance);
                        ps.setString(3, accBranch);
                        ps.setInt(4, cusId);
                        ps.addBatch();
                    }
                    ps.executeBatch();
                    System.out.println("Account Record inserted");
                } finally {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new CustomizedException("Account Detail Submission Failed, Query Error");
            }
    }

    //Delete Customer From Database
    public String deleteCustomer(Integer cusId) throws CustomizedException{
        String query="Update CustomerInfo SET CusStatus = 1 WHERE CusId ="+cusId+"";
        try {
            Statement st = getConnection().prepareStatement(query);
            return "Customer Deleted Successfully";
        }catch (SQLException e){
            throw  new CustomizedException("Customer Deletion Failed");
        }
    }
}