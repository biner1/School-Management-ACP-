package main.java.model.management;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import main.java.model.models.StaffPayment;

public class StaffPaymentList {
    private ArrayList<StaffPayment>StaffPayments;

    public StaffPaymentList(){

        StaffPayments = new ArrayList<>();

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

    public ArrayList<StaffPayment> getStaffPaymentByDate(String date){
        return StaffPayments.stream().filter(g -> Objects.equals(g.getPaymentDate(), date)).collect(Collectors.toCollection(ArrayList::new));
    }

    public  ArrayList<StaffPayment> getStaffPaymentBySalary(int salary){
        return StaffPayments.stream().filter(s -> s.getSalary() ==(salary)).collect(Collectors.toCollection(ArrayList::new));
    }
}
