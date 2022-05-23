package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter cells: ");
        Scanner scanner = new Scanner(System.in);
        String cellArray = scanner.next();
        char[] ch = new char[cellArray.length()];
        int countX = 0;
        int countO = 0;
        for (int i=0; i < cellArray.length(); i++) {
            ch[i] = cellArray.charAt(i);
        }
        char[][] array = {{cellArray.charAt(0), cellArray.charAt(1), cellArray.charAt(2)},
                {cellArray.charAt(3), cellArray.charAt(4), cellArray.charAt(5)},
                {cellArray.charAt(6), cellArray.charAt(7), cellArray.charAt(8)}};
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
        array[coordinate1 - 1][coordinate2 - 1] = 'X';
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
        boolean xWins = false;
        boolean oWins = false;
        for (int i = 0; i < cellArray.length(); i++) {
            if (ch[i] == 'X') {
                countX++;
            }
            if (ch[i] == 'O') {
                countO++;
            }
        }
        boolean a = ch[0] == ch[1] && ch[0] == ch[2] && ch[0] == 'X';
        boolean b = ch[3] == ch[4] && ch[3] == ch[5] && ch[3] == 'X';
        boolean c = ch[6] == ch[7] && ch[6] == ch[8] && ch[8] == 'X';
        boolean d = ch[0] == ch[1] && ch[0] == ch[2] && ch[0] == 'O';
        boolean e = ch[3] == ch[4] && ch[3] == ch[5] && ch[3] == '0';
        boolean f = ch[6] == ch[7] && ch[6] == ch[8] && ch[8] == '0';
        boolean g = ch[0] == ch[3] && ch[0] == ch[6] && ch[0] == 'X';
        boolean h = ch[1] == ch[4] && ch[1] == ch[7] && ch[1] == 'X';
        boolean i = ch[2] == ch[5] && ch[2] == ch[8] && ch[2] == 'X';
        boolean j = ch[0] == ch[3] && ch[0] == ch[6] && ch[0] == 'O';
        boolean k = ch[1] == ch[4] && ch[1] == ch[7] && ch[1] == 'O';
        boolean l = ch[2] == ch[5] && ch[2] == ch[8] && ch[2] == 'O';
        boolean m = ch[0] == ch[4] && ch[0] == ch[8] && ch[0] == 'X';
        boolean n = ch[2] == ch[4] && ch[2] == ch[6] && ch[2] == 'X';
        boolean o = ch[0] == ch[4] && ch[0] == ch[8] && ch[0] == 'O';
        boolean p = ch[2] == ch[4] && ch[2] == ch[6] && ch[2] == 'O';

        boolean XAndOWins = a && b || a && c || a && e || a && f || a && g || a && h || a && i || a && j || a && k
                || a && l || a && m || a && n || a && o || a && p || b && c || b && d || b && f || b && g
                || b && h || b && i || b && j || b && k || b && l || b && m || b && n || b && o ||
                b && p || c && d || c && e || c && g || c && h || c && i || c && j || c && k || c && l || c && m
                || c && n || c && o || c && p || d && e || d && f || d && g || d && h || d && i || d && j
                || d && k || d && l || d && m || d && n || d && o || d && p || e && f || e && g || e && h
                || e && i || e && j || e && k || e && l || e && m || e && n || e && o || e && p || f && g ||
                f && h || f && i || f && j || f && k || f && l || f && m || f && n || f && o || f && p ||
                g && h || g && i || g && j || g && k || g && l || g && m || g && n || g && o || g && p ||
                h && i || h && j || h && l || h && m || h && n || h && o || h && p || i && j || i && k || i && m
                || i && n || i && o || i && p || j && k || j && l || j && m || j && n || j && o || j && p ||
                k && l || k && m || k && n || k && o || k && p || l && m || l && n || l && o || l && p || m && n
                || m && p || n && o || o && p;
        boolean impossible = Math.abs(countX - countO) > 1;

        if (XAndOWins) {
            System.out.println("Impossible");
        }
        else if (impossible) {
            System.out.println("Impossible");
        } else {
            if (a) {
                xWins = true;
                System.out.println("X wins");
            }
            if (b) {
                xWins = true;
                System.out.println("X wins");
            }
            if (c) {
                System.out.println("X wins");
                xWins = true;
            }
            if (d) {
                System.out.println("0 wins");
                oWins = true;
            }
            if (e) {
                System.out.println("0 wins");
                oWins = true;
            }
            if (f) {
                System.out.println("0 wins");
                oWins = true;
            }
            if (g) {
                System.out.println("X wins");
                xWins = true;
            }
            if (h) {
                System.out.println("X wins");
                xWins = true;
            }
            if (i) {
                System.out.println("X wins");
                xWins = true;
            }
            if (j) {
                System.out.println("O wins");
                oWins = true;
            }
            if (k) {
                System.out.println("O wins");
                oWins = true;
            }
            if (l) {
                System.out.println("O wins");
                oWins = true;
            }
            if (m) {
                System.out.println("X wins");
                xWins = true;
            }
            if (n) {
                System.out.println("X wins");
                xWins = true;
            }
            if (o) {
                System.out.println("O wins");
                oWins = true;
            }
            if (p) {
                System.out.println("O wins");
                oWins = true;
            }
        }
        int count = 0;
        if (!a && !b && !c && !d && !e && !f && !g && !h && !i && !j && !k && !l && !m && !n && !o && !p && !r && !s) {
            for (int q = 0; q < cellArray.length(); q++) {
                if (ch[q] == '_') {
                    count++;
                }
            }
            if (count >= 1) {
                System.out.println("Game not finished");
            } else if (count < 1) {
                System.out.println("Draw");
            }
        }
    }
}
