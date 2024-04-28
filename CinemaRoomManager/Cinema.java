package cinema;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        int nbPurchasedTicket = 0;
        int nbPlaces = 0;
        int currentIncome = 0;
        int totalIncome = 0;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int nbRow = scan.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int nbSeat = scan.nextInt();

        totalIncome = profit(nbRow, nbSeat);
        nbPlaces = nbRow*nbSeat;

        menu();

        String[][] tab = new String[nbRow+1][nbSeat+1];
        init(tab);

        boolean app = true;

        while (app){
            switch (scan.nextInt()){
                case 1 :
                    System.out.println("Cinema:");

                    display(tab);
                    break;
                case 2:
                    int rowNumber = 0;
                    int seatNumber = 0;

                    boolean full = true;
                    while (full){

                        boolean outRow = true;
                        while (outRow){
                            System.out.println("Enter a row number: ");
                            rowNumber = scan.nextInt();
                            if (rowNumber > tab.length-1) {
                                System.out.println("Wrong input!");
                            } else {
                                outRow = false;
                            }
                        }

                        boolean outSeat = true;
                        while (outSeat){
                            System.out.println("Enter a seat number in that row:");
                            seatNumber = scan.nextInt();
                            if (seatNumber > tab[0].length-1) {
                                System.out.println("Wrong input!");
                            } else {
                                outSeat = false;
                            }
                        }

                        if (Objects.equals(tab[rowNumber][seatNumber], "B")){
                            System.out.println("That ticket has already been purchased!");
                        } else {
                            full = false;
                        }
                    }

                    int ticketPrice = ticketPrice(nbRow, nbSeat, rowNumber);
                    System.out.println("Ticket price: $" + ticketPrice);
                    System.out.println();
                    System.out.println("Cinema:");
                    tab[rowNumber][seatNumber] = "B";
                    display(tab);
                    nbPurchasedTicket ++;
                    currentIncome += ticketPrice;
                    break;
                case 3:
                    stat(nbPurchasedTicket, nbPlaces, currentIncome, totalIncome);
                    break;
                case 0 :
                    app = false;
                    break;
            }
            menu();
        }
    }

    public static void menu(){
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void stat(int nbPurchasedTicket, int nbPlaces, int currentIncome, int totalIncome){
        System.out.println("Number of purchased tickets: " + nbPurchasedTicket);
        DecimalFormat df = new DecimalFormat("####0.00");
        System.out.println("Percentage: " + df.format((double)(nbPurchasedTicket * 100)/nbPlaces) + "%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

    public static int ticketPrice (int nbRow, int nbSeat, int rowNumber){
        int ticketPrice = 0;

        if (nbRow*nbSeat < 60){
            ticketPrice = 10;
        } else {
            if (nbRow % 2 == 0){
                if (rowNumber <= nbRow/2){
                    ticketPrice = 10;
                } else {
                    ticketPrice = 8;
                }
            } else {
                if (rowNumber <= nbRow/2){
                    ticketPrice = 10;
                } else {
                    ticketPrice = 8;
                }
            }
        }
        return ticketPrice;
    }

    public static int profit(int nbRow, int nbSeat){
        int profit = 0;

        if (nbRow * nbSeat < 60){
            profit = nbRow * nbSeat * 10;
        } else {
            if (nbRow % 2 == 0){
                int front = nbRow/2*nbSeat*10;
                int back = nbRow/2*nbSeat*8;
                profit = front+back;
            } else {
                int front = nbRow/2*nbSeat*10;
                int back = (nbRow-nbRow/2)*nbSeat*8;
                profit = front+back;
            }
        }

        return profit;
    }

    public static void init(String[][] tab){
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = "S";
            }
        }

        for (int i = 1; i < tab.length; i++) {
            tab[i][0] = Integer.toString(i);
            for (int j = 1; j < tab[i].length; j++) {
                tab[0][j] = Integer.toString(j);

            }
        }

        tab[0][0] = " ";
    }
    public static void display(String[][] room){
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                System.out.print(room[i][j] + " ");
            }System.out.println();
        }
    }
}
