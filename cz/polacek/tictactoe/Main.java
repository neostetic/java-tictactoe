package cz.polacek.tictactoe;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static char player1 = 'E';
    private static char player2 = 'L';
    private static String[] message = {player1 + "'s turn", player2 + "'s turn"};
    private static Scanner sc = new Scanner(System.in);
    private static char[] board = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};
    private static int[] playerBoard = {-1, -1, -1, -1, -1, -1, -1, -1, -1}; // new int[9];
    private static byte playerBoardCount = 0;
    private static byte round = 0;
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

    private static void printBoard() {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }

    private static void gameTurn() {
        printBoard();
        int idChoose;
        int checkClear = 0;
        do {
            System.out.print("Choose an array: ");
            idChoose = sc.nextInt();
            int arrayIdChoose = idChoose;
            if (Arrays.stream(playerBoard).anyMatch(i -> i == arrayIdChoose)) {
                System.out.println("Sorry, wrong number...");
            } else {
                checkClear++;
            }
        } while (checkClear == 0);
        if (round % 2 == 0) {
            board[idChoose] = player1;
        } else {
            board[idChoose] = player2;
        }
        playerBoard[playerBoardCount] = idChoose;
        playerBoardCount++;
        round++;
        gameCheck();
    }

    private static void gameStartTurn() {
        System.out.println("\n" + message[round % 2]);
        gameTurn();
    }

    private static void gameCheck() {
        if (round < 9) {
            for (int i = 0; i < 2; i++) {
                char checkChar;
                if (i == 0) {
                    checkChar = player1;
                } else {
                    checkChar = player2;
                }
                for (int j = 0; j < combinations.length; j++) {
                    if (
                            board[combinations[j][0]] == checkChar &&
                                    board[combinations[j][1]] == checkChar &&
                                    board[combinations[j][2]] == checkChar
                    ) {
                        gameEnds();
                        return;
                    }
                }
            }
            gameStartTurn();
        } else {
            System.out.println("\nGame: Tie!");
        }
    }

    private static void gameEnds() {
        printBoard();
        if (round % 2 == 0) {
            System.out.println("\nGame: " + player2 + "'s wins");
        } else {
            System.out.println("\nGame: " + player1 + "'s wins");
        }
    }


    public static void main(String[] args) {
        gameStartTurn();
    }
}
