package org.example.logica;
import java.util.Scanner;

public class Game {
    private Box box;
    private byte winner;
    private Condition condition;

    public Game(){
        box = new Box();
        condition = new Condition(box);
        winner = 0;
    }

    public void play(){
        Scanner scan = new Scanner(System.in);
        byte input;
        boolean boxAvailable = false;

        System.out.println("Enter box number to select. Enjoy!\n");

        boolean boxEmpty = false;

        while (true) {
            box.draw();
            if(!boxEmpty){
                box.clear();
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
                    if (box.box[input - 1] == 'X' || box.box[input - 1] == 'O')
                        System.out.println("That one is already in use. Enter another.");
                    else {
                        box.box[input - 1] = 'X';
                        break;
                    }
                }
                else
                    System.out.println("Invalid input. Enter again.");
            }

            if(condition.checkWinner()){
                winner = 1;
                continue;
            }

            boxAvailable = condition.checkBoxAvailability();

            if(!boxAvailable){
                winner = 3;
                continue;
            }

            while (true) {
                byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (box.box[rand - 1] != 'X' && box.box[rand - 1] != 'O') {
                    box.box[rand - 1] = 'O';
                    break;
                }
            }

            if(condition.checkWinner()){
                winner = 2;
                continue;
            }
        }
    }
}