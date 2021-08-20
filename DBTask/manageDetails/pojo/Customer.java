package manageDetails.manageDetails.pojo;

import manageDetails.manageDetails.logicLayer.LoadDataToHMap;

public class Customer {


    //Variable
    private Integer cusID;
    private String name;
    private Long dofBirth;
    private String location;
    private String CusStatus;




    //Getter and Setter for name and Date
    public Integer getCusID() { return cusID; }
    public void setCusID(Integer cusID) { this.cusID = cusID; }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getDofBirth() {
        return dofBirth;
    }
    public void setDofBirth(Long dofBirth) {
        this.dofBirth = dofBirth;
    }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCusStatus() { return CusStatus; }
    public void setCusStatus(String cusStatus) { CusStatus = cusStatus; }

    @Override
    public String toString() {
        return "Customer{" +
                "cusID=" + cusID +
                ", name='" + name + '\'' +
                ", dofBirth=" + dofBirth +
                ", location='" + location + '\'' +
                ", CusStatus='" + CusStatus + '\'' +
                '}';
    }
}
