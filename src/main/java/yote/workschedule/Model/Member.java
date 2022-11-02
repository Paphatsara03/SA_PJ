package yote.workschedule.Model;

public class Member {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String phoneNumber;


    public Member(String name, String userName, String password, String phoneNumber) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return name + "," + userName + " , " + password + " , " + phoneNumber;
    }

    public String toCsv() {
        return name + " , " + userName + " , " + password + " , " + phoneNumber;
    }


}
