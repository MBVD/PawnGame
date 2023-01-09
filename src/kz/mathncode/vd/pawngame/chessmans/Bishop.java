package kz.mathncode.vd.pawngame.chessmans;

import kz.mathncode.vd.pawngame.position.Position;

public class Bishop extends Chessman {


    @Override
    public boolean canMove(Position position) {
        if (insideChessboard(position) && !position.equals(getPosition()) && (position.getX() + position.getY() == getPosition().getX() + getPosition().getY() || position.getY() - position.getX() == getPosition().getY() - getPosition().getY() )){
            return true;
        }
        return false;
    }

    public Bishop(Position position, boolean isWhite) {
        super(position, isWhite);
    }

    @Override
    public void view() {
        if (isWhite()){
            System.out.print("\u2657 ");
            // ♗
        }
        else
        {
            System.out.print("\u265D ");
            // ♝
        }
    }
}
