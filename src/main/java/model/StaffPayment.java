package main.java.model;
import java.util.Objects;

public class StaffPayment {
    private int paymentId;
    private int staffId;
    private int paymentAmount;
    private String paymentDate;

    public StaffPayment(int paymentId, int staffId , int paymentAmount, String paymentDate){
        this.paymentId=paymentId;
        this.staffId=staffId;
        this.paymentAmount=paymentAmount;
        this.paymentDate = paymentDate;
    }

    public int getPaymentId(){
        return paymentId;
    };

    public void setPaymentId(int paymentId){
        this.paymentId=paymentId;
    };

    public int getStaffId(){
        return staffId;
    };

    public void setStaffId(int staffId){
        this.staffId=staffId;
    };

    public int getPaymentAmount(){
        return paymentAmount;
    };

    public void setPaymentAmount(int paymentAmount){
        this.paymentAmount=paymentAmount;
    }

    public String getPaymentDate(){
        return paymentDate;
    };

    public void setPaymentDate(String paymentDate){
        this.paymentDate=paymentDate;
    };

    @Override
    public int hashCode() {
        return Objects.hash(paymentId);
    }


    public String toString() {
        return "authentication{" +
                "paymentId='" + paymentId+ '\'' +
                "staffId='" + staffId+ '\'' +
                "paymentAmount='" + paymentAmount+ '\'' +
                "paymentDate='" + paymentDate+ '\'' +
                '}';
    }
}