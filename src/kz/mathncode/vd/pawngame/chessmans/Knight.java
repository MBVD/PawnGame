package kz.mathncode.vd.pawngame.chessmans;

import kz.mathncode.vd.pawngame.position.Position;

public class Knight extends Chessman {
    @Override
    public boolean canMove(Position position) {
        if (insideChessboard(position)
                && (( Math.abs(getPosition().getX() - position.getX()) == 2 && Math.abs (getPosition().getY() - position.getY()) == 1)
                || (Math.abs(getPosition().getX() - position.getX()) == 1 && Math.abs (getPosition().getY() - position.getY()) == 2) )){
            return true;
        }
        return false;
    }

    public Knight(Position position, boolean isWhite) {
        super(position, isWhite);
    }


    @Override
    public void view() {
        if (isWhite()){
            System.out.print("\u265E ");
            // ♞
        }
        else {
            System.out.print("\u2658 ");
            // ♘♘
        }
    }
}
