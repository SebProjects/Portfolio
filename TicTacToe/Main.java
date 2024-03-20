package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        init();
        Scanner scan = new Scanner(System.in);
        int col = 0;
        int row = 0;

        String matrix = "         ";

        int in1 = 0;
        int in2 = 0;

        try {
            while(!GameNotFinished(matrix)){
                boolean check = false;
                while (!check){
                    if (scan.hasNextInt()) {
                        if (scan.hasNext("[1-3]")){
                            in1 = scan.nextInt();
                                if (scan.hasNext("[1-3]")) {
                                    in2 = scan.nextInt();
                                    if (!cellOccupied(matrix, in1, in2)){
                                        matrix = addValue(matrix, in1, in2);
                                        check = true;
                                    }
                                } else {
                                    System.out.println("Coordinates should be from 1 to 3!");
                                    scan.next();
                                }
                        } else {
                            System.out.println("Coordinates should be from 1 to 3!");
                            scan.next();
                            scan.next();
                        }
                    } else {
                        System.out.println("You should enter numbers!");
                        scan.next();
                        scan.next();
                    }
                }
                display(matrix);
            }
        } catch (Exception e){
            System.out.println("Error : " + e);
        }
    }

    public static String addValue(String in, int col, int row){
        int k = 0;
        char[][] tab = new char[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                tab[i][j] = in.charAt(k);
                k++;
            }
        }

        int x = 0;
        int o = 0;

        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (tab[i][j] == 'X') {
                    x++;
                } else if (tab[i][j] == 'O') {
                    o++;
                }
            }
        }

        if (x == 0){
            tab[row-1][col-1] = 'X';
        } else if (x > o) {
            tab[row-1][col-1] = 'O';
        } else {
            tab[row-1][col-1] = 'X';
        }

        String s = "";
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                s = s + tab[i][j];
            }
        }
        return s;
    }

    public static void display(String in){
        System.out.println("---------");
        System.out.println("| " + in.charAt(0) + " " + in.charAt(1) + " " + in.charAt(2) + " |");
        System.out.println("| " + in.charAt(3) + " " + in.charAt(4) + " " + in.charAt(5) + " |");
        System.out.println("| " + in.charAt(6) + " " + in.charAt(7) + " " + in.charAt(8) + " |");
        System.out.println("---------");
    }

    public static void init(){
        System.out.println("---------");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("---------");
    }

    public static boolean cellOccupied(String in, int col, int row){
        int k = 0;
        char[][] tab = new char[3][3];
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                tab[i][j] = in.charAt(k);
                k++;
            }
        }
        if (tab[row-1][col-1] != 32 ){
            System.out.println("This cell is occupied! Choose another one!");
            return true;
        }
        return false;
    }

    public static boolean Impossible(String[] tab, String in){
            if (tab[0].equals("XXX") && tab[1].equals("OOO") ||
                    tab[0].equals("XXX") && tab[2].equals("OOO") ||
                    tab[1].equals("XXX") && tab[2].equals("OOO") ||
                    tab[3].equals("XXX") && tab[4].equals("OOO") ||
                    tab[3].equals("XXX") && tab[5].equals("OOO") ||
                    tab[4].equals("XXX") && tab[5].equals("OOO") ||
                    tab[0].equals("OOO") && tab[1].equals("XXX") ||
                    tab[0].equals("OOO") && tab[2].equals("XXX") ||
                    tab[1].equals("OOO") && tab[2].equals("XXX") ||
                    tab[3].equals("OOO") && tab[4].equals("XXX") ||
                    tab[3].equals("OOO") && tab[5].equals("XXX") ||
                    tab[4].equals("OOO") && tab[5].equals("XXX")) {
                System.out.println("3 O et 3 X");
                return true;
            }
            int x = 0;
            int o = 0;
            for (int i=0;i<9;i++){
                if (in.charAt(i) == 'X'){
                    x++;
                }
                if (in.charAt(i) == 'O'){
                    o++;
                }
            }
            if (x-o > 1 || o-x > 1){
                return true;
            }
        return false;
    }

    public static boolean GameNotFinished(String matrix){
            if (!matrix.contains(" ")) {
                System.out.println("Draw");
                return true;
            }

        String[] tab = new String[8];

        tab[0] = String.valueOf(matrix.charAt(0))+String.valueOf(matrix.charAt(1))+String.valueOf(matrix.charAt(2));
        tab[1] = String.valueOf(matrix.charAt(3))+String.valueOf(matrix.charAt(4))+String.valueOf(matrix.charAt(5));
        tab[2] = String.valueOf(matrix.charAt(6))+String.valueOf(matrix.charAt(7))+String.valueOf(matrix.charAt(8));
        tab[3] = String.valueOf(matrix.charAt(0))+String.valueOf(matrix.charAt(3))+String.valueOf(matrix.charAt(6));
        tab[4] = String.valueOf(matrix.charAt(1))+String.valueOf(matrix.charAt(4))+String.valueOf(matrix.charAt(7));
        tab[5] = String.valueOf(matrix.charAt(2))+String.valueOf(matrix.charAt(5))+String.valueOf(matrix.charAt(8));
        tab[6] = String.valueOf(matrix.charAt(0))+String.valueOf(matrix.charAt(4))+String.valueOf(matrix.charAt(8));
        tab[7] = String.valueOf(matrix.charAt(2))+String.valueOf(matrix.charAt(4))+String.valueOf(matrix.charAt(6));

        if (WinsO(tab)){
            System.out.println("O wins");
            return true;

        } else if (WinsX(tab)) {
            System.out.println("X wins");
            return true;
        }
        return false;
    }

    public static boolean WinsO(String[] tab){
        for (String s : tab) {
            if (s.equals("OOO")) {
                return true;
            }
        }
        return false;
    }

    public static boolean WinsX(String[] tab){
        for (String s : tab) {
            if (s.equals("XXX")) {
                return true;
            }
        }
        return false;
    }
}
