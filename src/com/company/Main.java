package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] ch = new char[9];
        int countX = 0;
        int countO = 0;
        char element = '_';
        char[][] array = new char[3][3];
        boolean xWins = false;
        boolean oWins = false;
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0 && j == 0 || i == 1 && j == 0 || i == 2 && j == 0) {
                    System.out.print("| ");
                }
                array[i][j] = element;
                System.out.print(array[i][j] + " ");
                if (i == 0 && j == 2 || i == 1 && j == 2 || i == 2 && j == 2) {
                    System.out.println("|");
                }
            }
        }
        System.out.println("---------");
        boolean player1 = true;
        boolean gameHasEnded = false;
        while (!gameHasEnded) {
            if (player1) {
                element = 'X';
            } else {
                element = 'O';
            }
            int coordinate1 = 0;
            int coordinate2 = 0;
            while (true) {
                try {
                    System.out.println("Enter the coordinates: ");
                    coordinate1 = scanner.nextInt();
                    coordinate2 = scanner.nextInt();
                    if (coordinate1 < 1 || coordinate2 < 1 || coordinate1 > 3 || coordinate2 > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else if (array[coordinate1 - 1][coordinate2 - 1] != '_') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        break;
                    }
                } catch (Exception exception) {
                    System.out.println("You should enter numbers!");
                }
            }
            array[coordinate1 - 1][coordinate2 - 1] = element;
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 0 && j == 0 || i == 1 && j == 0 || i == 2 && j == 0) {
                        System.out.print("| ");
                    }
                    System.out.print(array[i][j] + " ");
                    if (i == 0 && j == 2 || i == 1 && j == 2 || i == 2 && j == 2) {
                        System.out.println("|");
                    }
                }
            }
            System.out.println("---------");
            Win(array);
            Draw(array);
            for (int i = 0; i < 9; i++) {
                if (ch[i] == 'X') {
                    countX++;
                }
                if (ch[i] == 'O') {
                    countO++;
                }
            }
            boolean impossible = Math.abs(countX - countO) > 1;
            if (impossible) {
                System.out.println("Impossible");
            }
            if (Win(array)) {
                gameHasEnded = true;
            }
        }
    }

    private static void Draw(char[][] array) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == '_') {
                    count++;
                }
            }
        }
        if (count < 1) {
            System.out.println("Draw");
        }
    }

    private static boolean Win(char[][] array) {
        for (int i = 0; i < 3; i++) {
            if (array[i][0] == array[i][1] && array[i][0] == array[i][2]) {
                if (array[i][0] == 'X') {
                    System.out.println("X wins");
                } else if (array[i][0] == 'O') {
                    System.out.println("O wins");
                }
            }
        }
        for (int j = 0; j < 3; j++) {
            if (array[0][j] == array[1][j] && array[0][j] == array[2][j]) {
                if (array[0][j] == 'X') {
                    System.out.println("X wins");
                } else if (array[0][j] == 'O') {
                    System.out.println("O wins");
                }
            }
        }
        if (array[0][0] == array[1][1] && array[0][0] == array[2][2]) {
            if (array[0][0] == 'X') {
                System.out.println("X wins");
            } else if (array[0][0] == 'O') {
                System.out.println("O wins");
            }
        }
        if (array[0][2] == array[1][1] && array[0][2] == array[2][0]) {
            if (array[0][2] == 'X') {
                System.out.println("X wins");
            } else if (array[0][2] == 'O') {
                System.out.println("O wins");
            }
        }
        return false;
    }
}
