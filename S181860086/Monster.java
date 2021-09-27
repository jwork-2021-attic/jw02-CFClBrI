package S181860086;

import S181860086.Shape.Position;

public class Monster implements Linable {

    private final int r;
    private final int g;
    private final int b;

    private Position position;
    private int value;

    Monster(int r, int g, int b, int value) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.value = value;
    }

    @Override
    public String toString() {
        String valueStr = Integer.toString(this.value);
        int len = valueStr.length();
        if (len == 1) {
            valueStr = " " + valueStr + " ";
        } else if (len == 2) {
            valueStr += " ";
        }
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + valueStr + "  \033[0m";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public void swapPosition(Monster another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int getValue() {
        return this.value;
    }

}
