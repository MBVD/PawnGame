package kz.mathncode.vd.pawngame.exceptions;

import kz.mathncode.vd.pawngame.position.Position;

public class UncreatedChessmanException extends RuntimeException{
    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public UncreatedChessmanException(String message, Position position){
        super(message);
        setPosition(position);
    }
}
