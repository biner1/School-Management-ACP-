package main.java.model;

public class School {

    private String schoolName;
    private String schoolAddress;
    private String schoolType;
    private String  schoolPhone;

    public School(String schoolName, String schoolAddress, String schoolType, String schoolPhone){
        this.schoolAddress = schoolAddress;
        this.schoolName = schoolName;
        this.schoolType = schoolType;
        this.schoolPhone = schoolPhone;
    }

    public String getSchoolName(){
        return schoolName;
    }

    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    public String getSchoolAddress(){
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress){
        this.schoolAddress = schoolAddress;
    }

    public String getSchoolType(){
        return schoolType;
    }

    public void setSchoolType(String schoolType){
        this.schoolType = schoolType;
    }

    public String  getSchoolPhone(){
        return schoolPhone;
    }

    public void setSchoolPhone(String schoolPhone){
        this.schoolPhone = schoolPhone;
    }

    public String toString() {
        return "School{" +
                "schoolName='" + schoolName + '\'' +
                ", schoolAddress='" + schoolAddress + '\'' +
                ", schoolType='" + schoolType + '\'' +
                ", schoolPhone='" + schoolPhone + '\'' +
                '}';
    }

}
