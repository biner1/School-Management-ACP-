package main.java.model.management;

import java.util.ArrayList;

import main.java.model.models.Staff;
import main.java.model.models.StaffRole;

public class StaffList {

    private ArrayList<Staff> staffs;

    public StaffList(){
        staffs = new ArrayList<Staff>();

        staffs.add(new Staff(1, "biner", "male", "1-1-2000", "biner@biner.com", "halabja", "07501111111", StaffRole.ADMIN, 9000000, "password"));
        staffs.add(new Staff(2, "abdulla", "male", "2-2-2002", "abdulla@abdulla.com", "slemani", "07501111112", StaffRole.TEACHER, 5000000, "password"));
        staffs.add(new Staff(3, "zeynab", "female", "2-2-2000", "zeynab@zeynab.com", "erbil", "07501111113", StaffRole.ACCOUNTANT, 7000000, "password"));
        staffs.add(new Staff(4, "darya", "female", "2-2-2002", "darya@darya.com", "erbil", "07501111114", StaffRole.TEACHER, 6000000, "password"));
        staffs.add(new Staff(5, "muhammed", "male", "21-2-2001", "muhammed@muhammed.com", "erbil", "07501111115", StaffRole.TEACHER, 5000000, "password"));
        staffs.add(new Staff(6, "naz", "female", "1-1-2001", "naz@naz.com", "erbil", "07501111116", StaffRole.TEACHER, 6000000, "password"));

    }// StaffList

    public void addStaff(Staff staff){
        staffs.add(staff);
    }

    public ArrayList<Staff> getStaffs() {
        return staffs;
    }
}
