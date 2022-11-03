package main.java.model;
import java.io.Serializable;
import java.util.Objects;

public class StudentPayment implements Serializable {
    private int paymentId;
    private int studentId;
    private int paymentAmount;
    private String paymentDate;

    public StudentPayment(int paymentId, int studentId , int paymentAmount, String paymentDate){
        this.paymentId=paymentId;
        this.studentId=studentId;
        this.paymentAmount=paymentAmount;
        this.paymentDate = paymentDate;
    }

    public int getPaymentId(){
        return paymentId;
    };

    public void setPaymentId(int paymentId){
        this.paymentId=paymentId;
    };

    public int getStudentId(){
        return studentId;
    };

    public void setStudentId(int studentId){
        this.studentId=studentId;
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
                "studentId='" + studentId+ '\'' +
                "paymentAmount='" + paymentAmount+ '\'' +
                "paymentDate='" + paymentDate+ '\'' +
                '}';
    }
}