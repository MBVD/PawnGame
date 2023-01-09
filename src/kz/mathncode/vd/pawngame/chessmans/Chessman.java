package kz.mathncode.vd.pawngame.chessmans;

import kz.mathncode.vd.pawngame.chessboard.Chessboard;
import kz.mathncode.vd.pawngame.position.Position;

public abstract class Chessman {
    private boolean isWhite;
    private Position position;



    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    public boolean isWhite() {
        return isWhite;
    }


    public void setWhite(boolean white) {
        isWhite = white;
    }

    public Chessman(Position position, boolean isWhite) {
        this.isWhite = isWhite;
        this.position = position;
    }


    public boolean insideChessboard (Position position){
        return position.getX() >= Chessboard.MIN_X && position.getX() < Chessboard.WIDTH && position.getY() >= Chessboard.MIN_Y && position.getY() < Chessboard.LENGTH;
    }

    public boolean canEat (Position position){
        return (canMove(position));
    }


    public boolean canMove (Position Position){
        throw new RuntimeException("Ошибка #1!");
    }


    public void view (){
        throw new RuntimeException("Привет, я ошибка !");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chessman chessman = (Chessman) o;
        return isWhite == chessman.isWhite && position.equals(chessman.getPosition());
    }
}
