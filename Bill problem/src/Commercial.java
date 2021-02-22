import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//Electricity bill for Commercial users
class Commercial {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void calculateBill(int units){
        System.out.println("Customer -> "+getName());
        System.out.println("Bill amount = "+units*5.00);
    }
}
//Electricity bill for Domestic users
class Domestic extends Commercial{
    void calculateBill(int units){
        System.out.println("Customer -> "+getName());
        System.out.println("Bill amount = "+units*2.50);
    }
}

class ElectricityBill {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please Enter your name -> ");
        String name = br.readLine();
        System.out.print("Please Enter your total units -> ");
        int units = Integer.parseInt(br.readLine());

        System.out.println("Which kind of user are you? ");
        System.out.print("Please select from the options given ->  ");
        System.out.println("1.Commercial User");
        System.out.println("                                         2.Domestic User");

        //Getting Response
        Scanner scanner = new Scanner(System.in);
        int response = scanner.next().charAt(0);

        if (response == '1'){
            System.out.println("Welcome Dear commercial user, "+name);
            Commercial commercial = new Commercial();
            commercial.setName(name);

            System.out.println("Your used electricity units are -> "+units);
            System.out.print("If these are your units -> ");
            System.out.println("Hit 1 for 'yes' and 0 for 'no'");
            int commercial_verification = scanner.next().charAt(0);
            if (commercial_verification == '1'){
                System.out.println("Your bill is in processing.you will be able to see your bill amount.");
                commercial.calculateBill(units);
                System.out.println("Thank you visit again!");
            } else if (commercial_verification == '0') {
                System.out.println("You have entered the wrong amount of bill.You will be redirected to starting or try restarting the program");
                System.exit(0);
            }else {
                System.out.println("Please enter from the option listed above");
                System.exit(0);
            }
        }else if (response == '2'){
            System.out.println("Welcome Dear domestic user, "+name);
            Domestic domestic = new Domestic();
            domestic.setName(name);

            System.out.println("Your used electricity units are -> "+units);
            System.out.print("If these are your units -> ");
            System.out.println("Hit 1 for 'yes' and 0 for 'no'");
            int domestic_verification = scanner.next().charAt(0);
            if (domestic_verification == '1'){
                System.out.println("Your bill is in processing.you will be able to see your bill amount.");
                domestic.calculateBill(units);
                System.out.println("Thank you visit again!");
            }else if (domestic_verification == '0'){
                System.out.println("You have entered the wrong amount of bill.You will be redirected to starting or try restarting the program");
                System.exit(0);
            }else {
                System.out.println("Please enter from the option listed above");
                System.exit(0);
            }
        }else {
            System.out.println("Please select an option from the given options!");
            System.exit(0);
        }
    }
}