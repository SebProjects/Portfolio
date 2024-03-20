package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of rows: ");
        int nbRow = scan.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int nbSeat = scan.nextInt();

        String[][] tab = new String[nbRow+1][nbSeat+1];

        System.out.println("Cinema:");
        init(tab);
        display(tab);

        //System.out.println("Total income: ");
        //System.out.println("$" + profit(nbRow, nbSeat));
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