package kz.mathncode.vd.pawngame.chessmans;

import kz.mathncode.vd.pawngame.position.Position;

public class Pawn extends Chessman {
    private boolean stationary;
    public static final int PAWN_POSITION_1_X = 0;
    public static final int PAWN_POSITION_2_X = 7;
    private final int STATIONARY_PAWN_MOVE_CONDITION_CONSTANT = 2;
    private final int PAWN_MOVE_CONDITION_CONSTANT = 1;
    @Override
    public boolean canMove(Position position) { //  также устанавливает автоматически position
       if (isWhite()){
           if ((isStationary() && getPosition().getX()-position.getX() == STATIONARY_PAWN_MOVE_CONDITION_CONSTANT && position.getY() == position.getY())
               || (getPosition().getX() - position.getX() == PAWN_MOVE_CONDITION_CONSTANT && position.getY() == getPosition().getY())){
               setStationary(false);
               return true;
           }
       }
       else
       {
           if ((isStationary() && position.getX() - getPosition().getX() == 2 && position.getY() == position.getY())
                   || ( position.getX() - getPosition().getX() == 1 && position.getY() == getPosition().getY())){
               setStationary(false);
               return true;
           }
       }
        return false;
    }

    public boolean isStationary() {
        return stationary;
    }

    public void setStationary(boolean stationary) {
        this.stationary = stationary;
    }

    public Pawn(Position position, boolean isWhite, boolean stationary) {
        super(position, isWhite);
        this.stationary = stationary;
    }
    @Override
    public boolean canEat(Position position) {
        if (isWhite()){
            if (getPosition().getX() - position.getX() == PAWN_MOVE_CONDITION_CONSTANT
                    && Math.abs(getPosition().getY() - position.getY()) == PAWN_MOVE_CONDITION_CONSTANT){
                setStationary(false);
                return true;
            }
        }
        else {
            if (position.getX() - getPosition().getX() == PAWN_MOVE_CONDITION_CONSTANT
                    && Math.abs(getPosition().getY() - position.getY()) == PAWN_MOVE_CONDITION_CONSTANT){
                setStationary(false);
                return true;
            }
        }
        return false;
    }

    @Override
    public void view() {
        if (isWhite()){
            System.out.print("\u265F");
            // ♟
        }
        else
        {
            System.out.print("\u2659");
            // ♙
        }
    }
}
