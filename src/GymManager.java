import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GymManager {
    private List<GymMember> gymMemberList = new ArrayList<>();
    private List<Trainer> trainerList = new ArrayList<>();
    private List<GymEquipment> equipmentList = new ArrayList<>();
    private List<FitnessClass> classList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GymManager gymManager = new GymManager();
        gymManager.fillLists(); // Call the method to populate initial data

        int choice;

        do {
            System.out.println("------ Main Menu ------");
            System.out.println("1. Members Menu");
            System.out.println("2. Trainers Menu");
            System.out.println("3. FitnessClass Menu");
            System.out.println("4. Equipment Menu");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    gymManager.membersMenu(scanner);
                    break;
                case 2:
                    // Call method to display Trainers Menu
                    gymManager.trainersMenu(scanner);
                    // Add your logic for Trainers Menu here
                    break;
                case 3:
                    gymManager.fitnessClassMenu(scanner);
                    break;
                case 4:
                    // Call method to display FitnessClass Menu
                    gymManager.bookEquipment(scanner);
                    // Add your logic for FitnessClass Menu here
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // functions
    // generate objects for lists
    public void fillLists() {
        GymMember m1 = new GymMember("Test", LocalDate.of(1999, 12, 12), "test@test.com", 99.99, MembershipType.GOLD);
        gymMemberList.add(m1);
        Trainer t1 = new Trainer("Jacob Aims", LocalDate.of(1996, 4, 3), "jacobtrains@gmail.com", "Coach");
        trainerList.add(t1);


        // Adding some gym equipment
        GymEquipment e1 = new GymEquipment();
        GymEquipment e2 = new GymEquipment();
        equipmentList.add(e1);
        equipmentList.add(e2);
    }

    // Members Menu with Submenu
    private void membersMenu(Scanner scanner) {
        int choice;

        do {
            System.out.println("------ Members Menu ------");
            System.out.println("1. View All Gym Members");
            System.out.println("2. Add a New Gym Member");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllMembers();
                    break;
                case 2:
                    addNewMember(scanner);
                    break;
                case 3:
                    System.out.println("Returning to the Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        } while (choice != 3);
    }

    private void viewAllMembers() {
        System.out.println("------ All Gym Members ------");
        for (GymMember member : gymMemberList) {
            System.out.println(member);
        }
    }

    private void addNewMember(Scanner scanner) {
        System.out.println("------ Adding a New Gym Member ------");
        System.out.print("Enter the name of the new gym member: ");
        String name = scanner.next();
        System.out.print("Enter the birth date (yyyy-mm-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.next());
        System.out.print("Enter the email address: ");
        String email = scanner.next();
        System.out.print("Enter the membership fee: ");
        double membershipFee = scanner.nextDouble();
        System.out.print("Enter the membership type (SILVER, GOLD, PLATINUM): ");
        MembershipType membershipType = MembershipType.valueOf(scanner.next().toUpperCase());

        GymMember newMember = new GymMember(name, birthDate, email, membershipFee, membershipType);
        gymMemberList.add(newMember);
        System.out.println("New gym member added: " + newMember);
    }

//Equipment menu
private void viewAllEquipment() {
    System.out.println("------ All Gym Equipment ------");
    for (GymEquipment equipment : equipmentList) {
        System.out.println(equipment);
    }
}

    private void bookEquipment(Scanner scanner) {
        System.out.print("Enter the name of the equipment you want to book: ");
        String equipmentName = scanner.next();
        System.out.print("Enter the name of the member to assign to the equipment: ");
        String memberName = scanner.next();

        for (GymEquipment equipment : equipmentList) {
            if (equipment.getEquipmentName().equalsIgnoreCase(equipmentName)) {
                if (equipment.isAvailable()) {
                    equipment.setEquipmentName(memberName);
                    equipment.setAvailable(false);
                    System.out.println("Equipment booked successfully.");
                } else {
                    System.out.println("Equipment is already booked. Choose another equipment.");
                }
                return;
            }
        }
        System.out.println("Equipment not found with the given name.");
    }

    // Trainers Menu with Submenu
    private void trainersMenu(Scanner scanner) {
        int choice;

        do {
            System.out.println("------ Trainers Menu ------");
            System.out.println("1. View All Trainers");
            System.out.println("2. Add a New Trainer");
            System.out.println("3. Get Trainer's Specialization by Name");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllTrainers();
                    break;
                case 2:
                    addNewTrainer(scanner);
                    break;
                case 3:
                    getTrainerSpecialization(scanner);
                    break;
                case 4:
                    System.out.println("Returning to the Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
    }

    private void viewAllTrainers() {
        System.out.println("------ All Trainers ------");
        for (Trainer trainer : trainerList) {
            System.out.println(trainer);
        }
    }

    private void addNewTrainer(Scanner scanner) {
        System.out.println("------ Adding a New Trainer ------");
        System.out.print("Enter the name of the new trainer: ");
        String name = scanner.next();
        System.out.print("Enter the birth date (yyyy-mm-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.next());
        System.out.print("Enter the email address: ");
        String email = scanner.next();
        System.out.print("Enter the specialization: ");
        String specialization = scanner.next();

        Trainer newTrainer = new Trainer(name, birthDate, email, specialization);
        trainerList.add(newTrainer);
        System.out.println("New trainer added: " + newTrainer);
    }

    private void getTrainerSpecialization(Scanner scanner) {
        System.out.print("Enter the name of the trainer: ");
        String name = scanner.next();
        for (Trainer trainer : trainerList) {
            if (trainer.getSpecialisation().equalsIgnoreCase(name)) {
                System.out.println("Trainer's Specialization: " + trainer.getSpecialisation());
                return;
            }
        }
        System.out.println("Trainer not found with the given name.");
    }
    private void fitnessClassMenu(Scanner scanner) {
        int choice;

        do {
            System.out.println("------ Fitness Class Menu ------");
            System.out.println("1. View All Fitness Classes");
            System.out.println("2. Add a New Fitness Class");
            System.out.println("3. Book a Fitness Class");
            System.out.println("4. Check Availability of a Fitness Class");
            System.out.println("5. Back to Members Menu");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllFitnessClasses();
                    break;
                case 2:
                    addNewFitnessClass(scanner);
                    break;
                case 3:
                    bookFitnessClass(scanner);
                    break;
                case 4:
                    checkFitnessClassAvailability(scanner);
                    break;
                case 5:
                    System.out.println("Returning to the Members Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
    }

    private void viewAllFitnessClasses() {
        System.out.println("------ All Fitness Classes ------");
        for (FitnessClass fitnessClass : classList) {
            System.out.println(fitnessClass);
        }
    }

    private void addNewFitnessClass(Scanner scanner) {
        System.out.println("------ Adding a New Fitness Class ------");
        System.out.print("Enter the name of the fitness class: ");
        String className = scanner.next();
        System.out.print("Enter the time of the fitness class: ");
        String classTime = scanner.next();

        FitnessClass newFitnessClass = new FitnessClass(className, classTime);
        classList.add(newFitnessClass);
        System.out.println("New fitness class added: " + newFitnessClass);
    }

    private void bookFitnessClass(Scanner scanner) {
        System.out.print("Enter the name of the fitness class you want to book: ");
        String className = scanner.next();
        System.out.print("Enter the name of the member to assign to the fitness class: ");
        String memberName = scanner.next();

        for (FitnessClass fitnessClass : classList) {
            if (fitnessClass.getClassName().equalsIgnoreCase(className)) {
                if (fitnessClass.getSchedule()) {
                    fitnessClass.setClassName(memberName);
                    fitnessClass.setSchedule(String.valueOf(false));
                    System.out.println("Fitness class booked successfully.");
                } else {
                    System.out.println("Fitness class is already booked. Choose another class.");
                }
                return;
            }
        }
        System.out.println("Fitness class not found with the given name.");
    }

    private void checkFitnessClassAvailability(Scanner scanner) {
        System.out.print("Enter the name of the fitness class to check availability: ");
        String className = scanner.next();

        for (FitnessClass fitnessClass : classList) {
            if (fitnessClass.getClassName().equalsIgnoreCase(className)) {
                if (fitnessClass.getSchedule()) {
                    System.out.println("Fitness class is available for booking.");
                } else {
                    System.out.println("Fitness class is already booked. Choose another class.");
                }
                return;
            }
        }
        System.out.println("Fitness class not found with the given name.");
    }

}
