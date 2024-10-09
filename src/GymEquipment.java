import java.time.LocalDate;

public class GymEquipment {

    private GymMember currentUser;

    private String equipmentName;

    private boolean isAvailable;

    public GymEquipment(String name, LocalDate dob, String email, GymMember currentUser, String equipmentName, boolean isAvailable) {
        this.currentUser = currentUser;
        this.equipmentName = equipmentName;
        this.isAvailable = isAvailable;
    }

    public GymEquipment() {

    }

    public GymMember getCurrentUser() {return getCurrentUser();}

    public void setCurrentUser (GymMember currentUser){this.currentUser = currentUser;}

    public String getEquipmentName(){return getEquipmentName();}

    public  void setEquipmentName(String equipmentName){this.equipmentName = equipmentName;}

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
