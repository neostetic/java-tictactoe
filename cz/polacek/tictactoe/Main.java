package cz.polacek.tictactoe;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static String[] message = {"X's turn", "O's turn"};
    private static Scanner sc = new Scanner(System.in);
    private static char[] board = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static int[] playerXboard;
    private static int[] playerOboard;
    private static int[][] combinations = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 4, 8},
            {2, 4, 6},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8}
    };

    private static byte round = 0;

    private static void printBoard() {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    private static void gameTurn() {
        printBoard();
        System.out.print("Choose array: ");
        int idChoose = sc.nextInt();
        if (round%2 == 0) {
            board[idChoose] = 'X';
        } else {
            board[idChoose] = 'O';
        }
        if (round > 7) {
            System.out.println("Tie!");
        } else {
            round++;
            gameCheck();
        }
    }

    private static void gameStartTurn() {
        System.out.println("\n" + message[round%2]);
        gameTurn();
    }

    private static void gameCheck() {
        for (int i = 0; i < 2; i++) {
            char checkChar;
            if (i == 0) checkChar = 'X';
            else checkChar = 'O';
            for (int[] combination : combinations) {
                if (
                        board[combination[0]] == checkChar &&
                        board[combination[1]] == checkChar &&
                        board[combination[2]] == checkChar
                ) {
                    gameEnds();
                } else {
                    gameStartTurn();
                }
            }
        }
    }

    private static void gameEnds() {
        if (round%2 == 0) {
            System.out.println("O's wins");
        } else {
            System.out.println("X's wins");
        }
    }


    public static void main(String[] args) {
        gameStartTurn();
    }
}
