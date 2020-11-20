package raffleTickets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;


public class Main {

//Ask if the user wants to check a raffle ticket or purchase one.
//If they purchase a raffle ticket their name needs to be stored with the random raffle ticket number.
//If they want to check a ticket, ask for the raffle number and name, if this matches and their raffle ticket number is a prime number they have won a prize.

    private static String userRaffle;


    public static void mainMenu() {
            try {
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Welcome to my raffle station! ");
                System.out.println("1.Draw a ticket \n2.Check Ticket");
                int menuSelection = Integer.parseInt(reader1.readLine());

                switch (menuSelection) {
                    case (1) -> buyTicket();
                    case (2) -> verifyRaffle();
                    default -> System.out.println("Please enter a valid input !");
                }

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }

    public static void clearScreen() {
        for(int i = 0; i<7; i++){
            System.out.println();
        }
    }

    public static void buyTicket(){
        try {
            Random randint = new Random();
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please enter your First name - ");
            String userName = reader1.readLine();
            int raffleNumber = randint.nextInt(91) + 10; //number will always be a positive 2 digit number
            System.out.println("Congratulations you have purchased a raffle");
            userRaffle = userName + " " +raffleNumber;
            //System.out.println(userRaffle);
           //System.out.println(userRaffle.charAt(userRaffle.length()-1));
        }catch(Exception e){
            System.out.println("Error: " + e );
        }
    }

    public static boolean isPrimeNumber(int x){
        if(x<=1) return true;
        for(int i = 2; i<x; i++) {
            if(x%i==0){
                return false;
            }
        }
        return true; //if all the number less than the raffleNumber give us something other than 0 when mod is used, it means that it is indivisible by those numbers and therefore is a prime number
    }

    public static void verifyRaffle(){
        try{
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your first name(with CAPS if required) : ");
            String userName = reader1.readLine();
            if(userRaffle.contains(userName)){      //checks if userRaffle has userName
                System.out.println("Your raffle has been found!");
                System.out.println(userRaffle);
                String raffleString = String.valueOf(userRaffle.charAt(userRaffle.length()-2)) + String.valueOf(userRaffle.charAt(userRaffle.length()-1)); //pulls out the last 2 char of userRaffle as a String
                //System.out.println(raffleString);
                int raffleInt = Integer.parseInt(raffleString); //converts String to int
                //System.out.println(raffleInt);
                if(isPrimeNumber(raffleInt)){ //checks if their raffle is a prime number
                    System.out.println("You have won!");
                }else{
                    System.out.println("You haven't won :( ");
                }
            }else{
                System.out.println("Your raffle has not been found"); //if the misspelled their name
            }

        }catch(Exception e){
            System.out.println("Error: "+ e);
        }
    }

    public static void main(String[] args) {

        while(true){
            try {
                BufferedReader mainReader = new BufferedReader(new InputStreamReader(System.in));
                mainMenu();
                System.out.print("Do you want to exit ? (y/n)");
                char loopAgain = mainReader.readLine().charAt(0);
                if(loopAgain=='y'){
                    System.out.println("Try me again sometime!\nGame has ended.");
                    break;
                }else{
                    clearScreen();
                }

            }catch(Exception e){
                System.out.println("Error " + e);
            }
        }
    }
}

