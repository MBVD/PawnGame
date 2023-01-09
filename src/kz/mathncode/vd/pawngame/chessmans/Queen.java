package kz.mathncode.vd.pawngame.chessmans;

import kz.mathncode.vd.pawngame.position.Position;

public class Queen extends Chessman {
    @Override
    public boolean canMove(Position position) {
        Bishop bishop = new Bishop(getPosition(), isWhite());
        Rook rook = new Rook(getPosition(), isWhite());
        if (bishop.canMove(position) || rook.canMove(position)){
            return true;
        }
        return false;
    }

    public Queen(Position position, boolean isWhite) {
        super(position, isWhite);
    }


    @Override
    public void view() {
        if (isWhite()){
            System.out.print("\u265B ");
            // ♛

        }
        else
        {
            System.out.print("\u2655 ");
            // ♕
        }
    }
}
