package manageDetails.manageDetails.pojo;

public class Customer {
    //Variable
    private String name;
    private long dofBirth;
    private String location;

    //Getter and Setter for name and Date
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public long getDofBirth() {
        return dofBirth;
    }
    public void setDofBirth(long dofBirth) {
        this.dofBirth = dofBirth;
    }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

}
