package controller;

import model.Board;

import java.time.LocalTime;

public class GameController {

    public static void main(String[] args) {

        Board nowaGra = new Board();

        /*System.out.println("podstawowa tablica");
        nowaGra.showBoard();
        System.out.println("ruch na dół");
        nowaGra.moveDown();
        System.out.println("ruch w prawo");
        nowaGra.moveRight();
        nowaGra.moveUp();*/
        nowaGra.moveLeft();
        nowaGra.showBoard();


    }
}
