package kz.mathncode.vd.pawngame.exceptions;

public class EndGameException extends RuntimeException {
    private int player;

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public EndGameException(String message, int player){
        super (message);
        setPlayer(player);
    }

    public EndGameException (String message){
        super(message);
    }


} 
