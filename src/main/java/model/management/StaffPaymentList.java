package main.java.model.management;
import main.java.model.models.StaffPayment;
import java.util.ArrayList;

public class StaffPaymentList {
    private ArrayList<StaffPayment>StaffPayments;

    public StaffPaymentList(){
        StaffPayments.add(new StaffPayment(1, 1, 14000, "30-1-2022"));
        StaffPayments.add(new StaffPayment(2, 2, 120000, "30-1-2022"));
        StaffPayments.add(new StaffPayment(3, 3, 140000, "30-1-2022"));
        StaffPayments.add(new StaffPayment(4, 4, 130000, "30-1-2022"));
        StaffPayments.add(new StaffPayment(5, 1, 120000, "30-1-2022"));
    }

    public void addStaffPayment(StaffPayment staffPayment){
        StaffPayments.add(staffPayment);
    }

    public ArrayList<StaffPayment> getStaffPayments(){

        return StaffPayments;
    }

//



}
