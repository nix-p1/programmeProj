import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class GymMember {

    private MembershipType membershipType;

    private double membershipFee;

    public GymMember(String name, LocalDate dob, String email, double mf, MembershipType membershipType) {
        this.membershipType = membershipType;
        this.membershipFee = mf;
    }


    public String getMembershipType() {
        return getMembershipType();
    }

    public void setMembershipType(MembershipType m) {
        this.membershipType = m;
    }

    public double getMembershipFee() {
        return getMembershipFee();
    }

    public void setMembershipFee(double mf) {
        this.membershipFee = mf;
    }



}


