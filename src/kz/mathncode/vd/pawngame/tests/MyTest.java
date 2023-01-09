package kz.mathncode.vd.pawngame.tests;

import kz.mathncode.vd.pawngame.chessmans.Chessman;
import kz.mathncode.vd.pawngame.chessmans.Pawn;
import kz.mathncode.vd.pawngame.chessmans.Queen;
import kz.mathncode.vd.pawngame.position.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyTest {

    @Test
    void dotInsideSquareFrameTest (){
        final Position position = new Position(0,7);
        final Position position1 = new Position(7,7);
        final Position position3 = new Position(1,7);
        assertTrue(position3.dotInsideSquareFrame(position1, position));
        assertFalse(position1.dotInsideSquareFrame(position3, position));
    }

    @Test
    void reconstruction (){
        Chessman chessman = new Pawn(new Position(1,2), true,true);
        chessman = new Queen(chessman.getPosition(), chessman.isWhite());
        assertFalse(chessman.equals(new Pawn(new Position(1, 2), true, true)));
        assertTrue(chessman.equals(new Queen(new Position(1, 2), true)));
    }

    @Test
    void ChessmanEquals(){
        final Chessman chessman = new Queen(new Position(1,0),true);
        final Chessman chessman1 = new Queen(new Position(1,0),true);
        assertTrue(chessman.equals(chessman1));
    }

    @Test
    void PawnCanEat (){
        Chessman pawn = new Pawn(new Position(2,1), false, false);
        Chessman pawn1 = new Pawn(new Position(3,0),true,false);
        assertTrue(pawn.canEat(pawn1.getPosition()));
        assertFalse(pawn1.canMove(pawn.getPosition()));
        assertFalse(pawn.canMove(pawn1.getPosition()));
    }
    @Test
    void CorrectValue(){
        String s = new String();
        s = "a1-a3";
        String[] pos = s.split("-");
        for (String s1: pos){
            char y = s1.charAt(0);
            char x = s1.charAt(1);
            System.out.print( 8 - (x - '0') + " ");
            System.out.print(y - 'a');
            System.out.println();
        }
    }
    @Test
    void IntChar(){
        int num = (int) 'a';

        System.out.println(num);
        num += 1;
        System.out.println((char) num);

    }

    @Test
    void StringClass(){
        System.out.print(Pawn.class.getTypeName());
        assertFalse("Pawn".equals(Pawn.class.getTypeName()));
    }


}
