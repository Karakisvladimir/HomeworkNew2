package org.example.logica;

public class Box {
    public char[] box;

    public Box(){
        box = new char[]{ '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    }

    public void draw(){
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    public void clear(){
        for(int i = 0; i < 9; i++)
            box[i] = ' ';
    }
}

