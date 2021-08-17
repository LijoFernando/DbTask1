package manageDetails.manageDetails.pojo;

public class AccountInfo {

    //variables
    private int AccId;
    private long AccNo;
    private int AccBalance;
    private String AccBranch;
    private int CusId;

    //Getter Setter Methods for Variables
    public int getAccId() {
        return AccId;
    }
    public void setAccId(int accId) {
        AccId = accId;
    }

    public long getAccNo() { return AccNo; }
    public void setAccNo(long accNo) {
               AccNo = accNo;
   }

    public int getAccBalance() {
        return AccBalance;
    }
    public void setAccBalance(int accBalance) {
        AccBalance = accBalance;
    }

    public String getAccBranch() {
        return AccBranch;
    }
    public void setAccBranch(String accBranch) {
        AccBranch = accBranch;
    }

    public int getCusId() {
        return CusId;
    }
    public void setCusId(int cusId) {
        CusId = cusId;
    }

    @Override
    public String toString() {
        return "["+getAccNo()+", "+getAccBalance()+", "+getAccBranch()+", "+getCusId()+"]";
    }


}
