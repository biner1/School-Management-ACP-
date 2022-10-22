package main.java.model.models;
import java.io.Serializable;
import java.util.Objects;

public class StaffPayment implements Serializable {
    private int paymentId;
    private int staffId;
    private int salary;
    private String paymentDate;

    public StaffPayment(int paymentId, int staffId , int salary, String paymentDate){
        this.paymentId=paymentId;
        this.staffId=staffId;
        this.salary = salary;
        this.paymentDate = paymentDate;
    }

    public int getPaymentId(){
        return paymentId;
    };

    public void setPaymentId(int paymentId){
        this.paymentId = paymentId;
    };

    public int getStaffId(){
        return staffId;
    };

    public void setStaffId(int staffId){
        this.staffId = staffId;
    };

    public int getSalary(){
        return salary;
    };

    public void setSalary(int paymentAmount){
        this.salary = paymentAmount;
    }

    public String getPaymentDate(){
        return paymentDate;
    };

    public void setPaymentDate(String paymentDate){
        this.paymentDate = paymentDate;
    };

    @Override
    public int hashCode() {
        return Objects.hash(paymentId);
    }

    public String toString() {
        return "authentication{" +
                "paymentId='" + paymentId+ '\'' +
                "staffId='" + staffId+ '\'' +
                "salary='" + salary+ '\'' +
                "paymentDate='" + paymentDate+ '\'' +
                '}';
    }
}