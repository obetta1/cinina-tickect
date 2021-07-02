

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // this is a methode that show the seat
    static void CinimaMenu() {
        System.out.println("1. Show the seats" + "\n2. Buy a ticket" + "\n3. Statistics" + "\n0. Exit");
    }

    static void assignedArray(String[][] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                array[i][j] = "s";
            }
        }
    }
    // this methode Exit the user from the program
    static void Exit() {
        System.out.println(" thank you, goodbye");
    }

    // this method is responsible for buy a ticket
    static void BuyTicket(String[][] array) {
        Scanner row = new Scanner(System.in);
        System.out.println("Enter a row number");
        int rowNumber = row.nextInt();
        System.out.println("Enter a seat number of that row");
        int seatNumber = row.nextInt();
        System.out.println("Ticket price  : $10");
        if (rowNumber < seatNumber) {
            System.out.println("Wrong input");
        }
        if (array[rowNumber][seatNumber].equals("B")) {
            System.out.println("That ticket has already been purchased!\n");
        } else {
            array[rowNumber][seatNumber] = "B";
            System.out.println(" ");
            
        }
    }


    /// this is the main method
    public static void main(String[] args) {

        try {
            Scanner scanna = new Scanner(System.in);
            System.out.println("Enter the numbers of row : ");
            int numberOfRow = scanna.nextInt();       // get the user input of number of rows
            System.out.println("Enter the number of seat in the row");
            int numberOfSeat = scanna.nextInt(); //==== get the user input of number of seat
            if (numberOfRow < numberOfSeat) {
                System.out.println("valide number, try again"); //--- checks if the number of seat is
                System.out.println("Enter the numbers of row : "); //--- more than number of row
            }
//declare an array and assign value "s" to it
            String[][] array = new String[numberOfRow][numberOfSeat];
             assignedArray(array);

            int select = 1;
            int count = 0;

            do {
                System.out.println("");
                // call the function CinimaMenu to display the option
                CinimaMenu();
                select = scanna.nextInt();

                //check the option selected by the user with if statement
                if (select == 1) {
                    for (int k = 1; k < numberOfSeat; k++) {
                        System.out.print("  " + k + "");
                    }
                    System.out.println("");
                    // this for loop is used to print out values of the array
                    for (int i = 1; i < numberOfRow; i++) {
                        System.out.print(i);
                        for (int j = 1; j < numberOfSeat; j++) {
                            System.out.print(" " + array[i][j] + " ");
                        }
                        System.out.println("");
                    }

                } else if (select == 2) {
                    ////---call BuyTicket method to buy a ticket
                    BuyTicket(array);

                } else if (select == 3) {

                    // this methode shows statistics of the ticket bought
                    int ticketPrice = 10;
                    double totalIncome = ticketPrice * (numberOfRow * numberOfSeat);
                    int NumberOfPurchasedTickets = count;
                    double Percentage = (double) (count * 100) / (double) (numberOfRow * numberOfSeat);
                    double CurrentIncome = count * ticketPrice;
                    System.out.println("Number Of Purchased Tickets  : " + NumberOfPurchasedTickets +
                            " \nPercentage : " + Percentage + "\nCurrentIncome :  " + CurrentIncome +
                            "\nticketPrice : " + ticketPrice + "\ntotalIncome :  $" + totalIncome);
                } else if (select == 0) {
                    ////----------Exit the program
                    Exit();
                }

            } while (select != 0);
        } catch (Exception e) {
            System.out.println("wrong input,");
        }
    }
}
