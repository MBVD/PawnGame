package kz.mathncode.vd.pawngame.position;

public class Position {
    private int x; // номер по вертикали
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean dotInsideSquareFrame(Position position, Position position1){
        return (Math.max(position.getX(), position1.getX()) >= getX()
                && Math.min(position.getX(), position1.getX()) <= getX()
                && Math.max(position.getY(), position1.getY()) >= getY()
                && Math.min(position.getY(), position1.getY()) <= getY()
                && !equals(position) && !equals(position1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
