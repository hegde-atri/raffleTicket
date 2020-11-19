package raffleTickets;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;

public class Main {

//Ask if the user wants to check a raffle ticket or purchase one.
//If they purchase a raffle ticket their name needs to be stored with the random raffle ticket number.
//If they want to check a ticket, ask for the raffle number and name, if this matches and their raffle ticket number is a prime number they have won a prize.

    public static void mainMenu(){
        try{
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Welcome to my raffle station! ");
            System.out.println("1 print hello \n 2 print goodbye");
            int menuSelection = Integer.parseInt(reader1.readLine());

            switch (menuSelection){
                case(1):
                    System.out.println("hello");
                    break;
                case (2):
                    System.out.println("goodbye");
                    break;
                default:
                    System.out.println("nope");
                    break;
            }

        }catch(Exception e){
            System.out.println("Exception: "+e);
        }

    }

    public static void textWriter(){

    }



    public static void main(String[] args) {
        mainMenu();
    }
}
