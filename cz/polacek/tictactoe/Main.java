package cz.polacek.tictactoe;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static String[] message = {"X's turn", "O's turn"};
    private static Scanner sc = new Scanner(System.in);
    private static char[] board = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static int[] playerXboard;
    private static int[] playerOboard;
    private static int[][] combinations = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 4, 8},
            {2, 4, 6},
            {1, 4, 7},
            {2, 5, 8}
    };

    private static byte round = 0;
    private static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.print(" | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i+j] + " | ");
            }
            System.out.println("\n");
        }
    }

    private static void gameTurn() {
        System.out.print("Choose array: ");
        int idChoose = sc.nextInt();
        if (round%2) {
            board[idChoose] = "X";
        } else {
            board[idChoose] = "O";
        }
    }

    private static void gameStartTurn() {
        System.out.println(message[round%2]);
        gameTurn();
        round++;
    }

    private static void gameCheck() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < board.length - 2; j++) {
                for (int k = 0; k < 3; k++) {
                    if (board[j]+k==combinations[i][k]) {
                        gameEnds();
                    }
                }
            }
        }
    }

    private static void gameEnds() {
        if (round%2) {
            System.out.println("X's wins");
        } else {
            System.out.println("O's wins");
        }
    }


    public static void main(String[] args) {
    }
}
