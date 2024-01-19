package org.example.logica;

import java.util.Scanner;

public class GameImpl2 {
    private char[] box;
    private byte winner;

    public GameImpl2(){
        box = new char[]{ '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        winner = 0;
    }

    public void play(){
        Scanner scan = new Scanner(System.in);
        byte input;
        byte i;
        boolean boxAvailable = false;

        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;

        while (true) {
            drawBox();
            if(!boxEmpty){
                clearBox();
                boxEmpty = true;
            }
            if(winner == 1){
                System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            } else if(winner == 2){
                System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            } else if(winner == 3){
                System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
                break;
            }
            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == 'X' || box[input - 1] == 'O')
                        System.out.println("That one is already in use. Enter another.");
                    else {
                        box[input - 1] = 'X';
                        break;
                    }
                }
                else
                    System.out.println("Invalid input. Enter again.");
            }

            if(checkWinner()){
                winner = 1;
                continue;
            }

            boxAvailable = checkBoxAvailability();

            if(!boxAvailable){
                winner = 3;
                continue;
            }

            while (true) {
                byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                    box[rand - 1] = 'O';
                    break;
                }
            }

            if(checkWinner()){
                winner = 2;
                continue;
            }
        }
    }

    private void drawBox(){
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    private void clearBox(){
        for(int i = 0; i < 9; i++)
            box[i] = ' ';
    }

    private boolean checkBoxAvailability(){
        for(int i=0; i<9; i++){
            if(box[i] != 'X' && box[i] != 'O'){
                return true;
            }
        }
        return false;
    }

    private boolean checkWinner(){
        if((box[0]=='X' && box[1]=='X' && box[2]=='X') || (box[3]=='X' && box[4]=='X' && box[5]=='X') || (box[6]=='X' && box[7]=='X' && box[8]=='X') ||
                (box[0]=='X' && box[3]=='X' && box[6]=='X') || (box[1]=='X' && box[4]=='X' && box[7]=='X') || (box[2]=='X' && box[5]=='X' && box[8]=='X') ||
                (box[0]=='X' && box[4]=='X' && box[8]=='X') || (box[2]=='X' && box[4]=='X' && box[6]=='X')){
            return true;
        } else if((box[0]=='O' && box[1]=='O' && box[2]=='O') || (box[3]=='O' && box[4]=='O' && box[5]=='O') || (box[6]=='O' && box[7]=='O' && box[8]=='O') ||
                (box[0]=='O' && box[3]=='O' && box[6]=='O') || (box[1]=='O' && box[4]=='O' && box[7]=='O') || (box[2]=='O' && box[5]=='O' && box[8]=='O') ||
                (box[0]=='O' && box[4]=='O' && box[8]=='O') || (box[2]=='O' && box[4]=='O' && box[6]=='O')){
            return true;
        }
        return false;
    }
}


