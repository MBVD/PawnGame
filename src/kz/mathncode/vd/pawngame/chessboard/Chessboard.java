package kz.mathncode.vd.pawngame.chessboard;

import kz.mathncode.vd.pawngame.position.Position;
import kz.mathncode.vd.pawngame.chessmans.*;

import java.util.ArrayList;
import java.util.List;

public class Chessboard {
    public static final int WIDTH = 8; // y
    public static final int LENGTH = 8; // x
    public static final int MAX_X = 7;
    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;
    public static final int FIRST_Y_STOPPER = 3;
    public static final int CELL_IS_WHITE_CONSTANT2 = 2;
    public static final int CELL_IS_WHITE_CONSTANT1 = 1;
    private List<Chessman>chessPieces;


    public Chessboard() {
        this.chessPieces = new ArrayList<>();
    }

    public List<Chessman> getChessPieces() {
        return chessPieces;
    }

    public void setChessPieces(List<Chessman> chessPieces) {
        this.chessPieces = chessPieces;
    }

    public void fill (){
        for (int i = 0; i<FIRST_Y_STOPPER; i++){
            chessPieces.add(new Pawn(new Position(Pawn.PAWN_POSITION_1_X, i),false,true));
            chessPieces.add(new Pawn (new Position(Pawn.PAWN_POSITION_2_X,i),true, true));
        }
        /*
        chessPieces.add(new Pawn(new Position(Pawn.PAWN_POSITION_1_X, 0),false,true));
        chessPieces.add(new Pawn (new Position(Pawn.PAWN_POSITION_2_X,0),true, true));
        */
    }

    public void paint (){
        for (int i = 0; i<WIDTH; i++){
            System.out.printf("%d ", WIDTH - i);
            for (int j = 0; j<LENGTH; j++){
                boolean noChessman = true;
                for (Chessman chessman: chessPieces){
                    if (chessman.getPosition().equals(new Position(i,j))){
                        noChessman = false;
                        chessman.view(); // рисуем фигуру по классу
                    }
                }
                if (noChessman){
                    cellView(new Position(i,j));
                }
            }
            System.out.println();
        }
        System.out.print("  ");
        for (int i = 1; i<=WIDTH; i++){
            int c = (int)'A';
            c += i-1;
            System.out.print((char) c + " ");
        }
        System.out.println();
    }




    public boolean cellIsWhite(Position position){
        return (position.getX() + position.getY()) % CELL_IS_WHITE_CONSTANT2 == CELL_IS_WHITE_CONSTANT1;
    }

    public void cellView (Position position){
        if (cellIsWhite(position)){
            System.out.print("\u25A0 ");
        }
        else
        {
            System.out.print("\u25A1 ");
        }
    }

}
