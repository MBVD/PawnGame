package kz.mathncode.vd.pawngame.chessmans;

import kz.mathncode.vd.pawngame.position.Position;

public class Rook extends Chessman {


    @Override
    public boolean canMove(Position position) {
        if (insideChessboard(position) && !position.equals(getPosition())
                && (position.getX() == getPosition().getX() || position.getY() == getPosition().getY())){
            return true;
        }
        return false;
    }

    public Rook(Position position, boolean isWhite) {
        super(position, isWhite);
    }


    @Override
    public void view() {
        if (isWhite()){
            System.out.print("\u265C ");
            // ♜
        }
        else
        {
            System.out.print("\u2656 ");
            // ♖
        }
    }
}
