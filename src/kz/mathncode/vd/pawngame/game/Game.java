package kz.mathncode.vd.pawngame.game;

import kz.mathncode.vd.pawngame.chessboard.Chessboard;
import kz.mathncode.vd.pawngame.chessmans.*;
import kz.mathncode.vd.pawngame.exceptions.EndGameException;
import kz.mathncode.vd.pawngame.exceptions.UncreatedChessmanException;
import kz.mathncode.vd.pawngame.exceptions.WrongMoveException;
import kz.mathncode.vd.pawngame.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Chessboard chessboard;
    public static final int DRAW_CONSTANT = 2;
    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int QUEUE_CONSTANT2 = 2;
    public static final int QUEUE_CONSTANT1 = 1;
    private List<Position> correctValue (String s){
        List<Position> Positions = new ArrayList<>();
        String[] pos = s.split("-");
        for (String s1: pos){
            char y = s1.charAt(0);
            char x = s1.charAt(1);
            Positions.add(new Position(Chessboard.WIDTH - (x - '0'), y - 'a'));
        }
        return Positions;
    }

    public void gameProcess(Scanner input, int queue) {
        try {
            while (true) {
                System.out.printf("%s игрок введите позиции\n", queue);
                try {
                    List<Position> positions = correctValue(input.nextLine());
                    Position begin = positions.get(0);
                    Position end = positions.get(1);
                    try {
                        step(begin, end, queue, input);
                        chessboard.paint();
                        endGame(queue);
                        queue = queue % QUEUE_CONSTANT2 + QUEUE_CONSTANT1;
                    } catch (WrongMoveException exception) {
                        System.out.println(exception.getMessage());
                    }
                } catch (UncreatedChessmanException exception) {
                    System.out.print(exception.getMessage());
                }
            }
        } catch (EndGameException exception) {
            System.out.println(exception.getMessage());
            System.exit(0);
        }
    }


    public void endGame(int queue) {
        if (chessboard.getChessPieces().size() == 1) {
            throw new EndGameException("Игра закончилась победой: " + queue, queue);
        } else if (chessboard.getChessPieces().size() == DRAW_CONSTANT) {
            if (chessboard.getChessPieces().get(0).getClass() == Pawn.class && chessboard.getChessPieces().get(1).getClass() == Pawn.class &&
                    chessboard.getChessPieces().get(0).canMove(chessboard.getChessPieces().get(1).getPosition())){
                throw new EndGameException("Ничья");
            }
        }
    } // кидает эксептьон ес че

    public boolean step(Position position, Position position1, int queue, Scanner input) {
        for (Chessman chessman : chessboard.getChessPieces()) {
            if (position.equals(chessman.getPosition())) { // находим фигуру по позиции position
                if (queue == FIRST && !chessman.isWhite()) {
                    throw new WrongMoveException("Ошибка #1");
                }
                if (queue == SECOND && chessman.isWhite()) {
                    throw new WrongMoveException("Ошибка #1");
                }

                for (Chessman chessman1 : chessboard.getChessPieces()) {
                    if (chessman1.getPosition().dotInsideSquareFrame(position, position1) && ((chessman.canMove(chessman1.getPosition())
                            && chessman.canMove(position1))
                            || chessman.canEat(chessman1.getPosition()) && chessman.canEat(position1))) {
                        throw new WrongMoveException("Ошибка #2"); // существует перегородка
                    }
                }

                for (Chessman chessman1: chessboard.getChessPieces()){
                    if (chessman1.getPosition().equals(position1)){
                        if (chessman.canEat(position1)){
                            chessboard.getChessPieces().remove(chessman1);
                            if (chessman.getClass() == Pawn.class && position1.getX() == Chessboard.MIN_X || position1.getX() == Chessboard.MAX_X){
                                Transformation(input, position1, chessman);
                            }
                            else
                            {
                                chessman.setPosition(position1);
                                return true;
                            }
                        }
                        if (chessman.canMove(position1)){
                            throw new WrongMoveException("Ошибка #3");
                        }
                    }
                }

                if (chessman.canMove(position1)){
                    if (chessman.getClass() == Pawn.class && position1.getX() == Chessboard.MIN_X || position1.getX() == Chessboard.MAX_X){
                        Transformation(input, position1, chessman);
                    }
                    else
                    {
                        chessman.setPosition(position1);
                    }
                    return true;
                }
                else
                {
                    throw new WrongMoveException("Ошибка #4");
                }
            }
        }
        throw new UncreatedChessmanException("Объект не существует!!!!\n", position);
    }

    private boolean Transformation (Scanner input, Position position, Chessman chessman){
        System.out.println("Желаемая фигура: ");
        String s = input.nextLine();
        if (s.equals("Q")){
            chessboard.getChessPieces().add(new Queen(position, chessman.isWhite()));
            chessboard.getChessPieces().remove(chessman);
            return true;
        }
        if (s.equals("B")){
            chessboard.getChessPieces().add(new Bishop(position, chessman.isWhite()));
            chessboard.getChessPieces().remove(chessman);
            return true;
        }
        if (s.equals("N")){
            chessboard.getChessPieces().add(new Knight(position, chessman.isWhite()));
            chessboard.getChessPieces().remove(chessman);
            return true;
        }
        if (s.equals("R")){
            chessboard.getChessPieces().add(new Rook(position, chessman.isWhite()));
            chessboard.getChessPieces().remove(chessman);
            return true;
        }
        throw new WrongMoveException("Ошибка #3");
    }

    public Game(Chessboard chessboard) {
            this.chessboard = chessboard;
        }

        public Chessboard getChessboard () {
            return chessboard;
        }

        public void setChessboard (Chessboard chessboard){
            this.chessboard = chessboard;
        }
}
