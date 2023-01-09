package kz.mathncode.vd.pawngame;

import kz.mathncode.vd.pawngame.chessboard.Chessboard;
import kz.mathncode.vd.pawngame.game.Game;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        Chessboard chessboard = new Chessboard();
        chessboard.fill();
        Game game = new Game(chessboard);
        game.getChessboard().paint();
        game.gameProcess(input, 1);

    }
}
