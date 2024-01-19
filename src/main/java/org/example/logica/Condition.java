package org.example.logica;

public class Condition {
    private Box box;

    public Condition(Box box) {
        this.box = box;
    }

    public boolean checkWinner(){
        if((box.box[0]=='X' && box.box[1]=='X' && box.box[2]=='X') || (box.box[3]=='X' && box.box[4]=='X' && box.box[5]=='X') || (box.box[6]=='X' && box.box[7]=='X' && box.box[8]=='X') ||
                (box.box[0]=='X' && box.box[3]=='X' && box.box[6]=='X') || (box.box[1]=='X' && box.box[4]=='X' && box.box[7]=='X') || (box.box[2]=='X' && box.box[5]=='X' && box.box[8]=='X') ||
                (box.box[0]=='X' && box.box[4]=='X' && box.box[8]=='X') || (box.box[2]=='X' && box.box[4]=='X' && box.box[6]=='X')){
            return true;
        } else if((box.box[0]=='O' && box.box[1]=='O' && box.box[2]=='O') || (box.box[3]=='O' && box.box[4]=='O' && box.box[5]=='O') || (box.box[6]=='O' && box.box[7]=='O' && box.box[8]=='O') ||
                (box.box[0]=='O' && box.box[3]=='O' && box.box[6]=='O') || (box.box[1]=='O' && box.box[4]=='O' && box.box[7]=='O') || (box.box[2]=='O' && box.box[5]=='O' && box.box[8]=='O') ||
                (box.box[0]=='O' && box.box[4]=='O' && box.box[8]=='O') || (box.box[2]=='O' && box.box[4]=='O' && box.box[6]=='O')){
            return true;
        }
        return false;
    }

    public boolean checkBoxAvailability(){
        for(int i=0; i<9; i++){
            if(box.box[i] != 'X' && box.box[i] != 'O'){
                return true;
            }
        }
        return false;
    }
}

