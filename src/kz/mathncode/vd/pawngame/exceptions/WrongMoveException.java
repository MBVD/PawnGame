package kz.mathncode.vd.pawngame.exceptions;

public class WrongMoveException extends RuntimeException{
    public WrongMoveException(String message) {
        super(message);
    }
}
